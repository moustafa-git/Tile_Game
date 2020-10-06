package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.music.EndThemeThread;
import dev.codenmore.tilegame.music.GameThemeThread;
import dev.codenmore.tilegame.music.MenuThemeThread;
import dev.codenmore.tilegame.states.CharacterSelection;
import dev.codenmore.tilegame.states.EndState;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.states.entities.creatures.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable{ //THAT IMPLEMENT ALLOWS IT TO RUN ON A THREAD.
    
    
    private Display display;
    private int width,height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs; //IT TELLS THE COMPUTER HOW TO DRAW THINGS TO THE SCREEN.
    private Graphics g;
    
    //STATES
    public State gameState;
    public State menuState;
    public State characterSelection;
    
    //INPUT
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //CAMERA
    private GameCamera gameCamera;
    
    //HANDLER
    private Handler handler;
    
    public Game(String title,int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    
    private void init(){ //INTIALIZES ALL THE GRAPHICS OF OUR GAME.
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
       
        
        
        menuState = new MenuState(handler);
        
        State.setState(menuState,"MenuState");
    }
    
    private void tick(){ //UPDTES EVERYTHING IN OUR GAME.
       keyManager.tick();
        
        if(State.getState() != null){
            State.getState().tick();
        }
    }
    
    private void render(){ //RNDERS OUR GAME.
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics(); //CREATING THE PAINT BRUSH.
        
        //CLEAR THE SCREEN , B4 WE CAN DRAW SOMETHING TO THE SCREEN WE HAVE TO CLEAR THE SCREEN EVERTIME WE RENDER.
        g.clearRect(0, 0, width, height);
        //DRAW HERE!
        
        if(State.getState() != null){
            State.getState().render(g);
        }
        
        //END DRAWING!
        bs.show();
        g.dispose();
    }
    
    public void run(){
        init();
        
        ///////////////////////////////////////////////////
        
        MenuThemeThread menuTheme = new MenuThemeThread();
        Thread t2 = new Thread(menuTheme);
        t2.start();
        
        GameThemeThread theme = new GameThemeThread();
        Thread t3 = new Thread(theme);
        t3.start();
        
        EndThemeThread end = new EndThemeThread();
        Thread t4 = new Thread(end);
        t4.start();
        

        
        ///////////////////////////////////////////////////
        
        int fps = 60; //THE AMOUNT OF TIME WE WANT TO CALL THE TICK AND RENDER METHOD EVERY SECOND.
        double timePerTick = 1000000000/fps; //MAKE IT HAVE 60 FPS CONTINUSLY SO THAT IT DOESNT DIFFER FROM ONE MACHINE TO ANOTHER.
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //THE CURRENT TIME OF THE COMPUTER IN NANO SECONDS
        long timer = 0;//TIMER AND TICKS IS JUST A VISUAL REPRESENTATION FOR YOU TO KNOW HOW MANY RENDERS AND TICKS ARE HAPPENING EACH SECOND.
        long ticks = 0;
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/ timePerTick;
            timer+= now-lastTime;
            lastTime = now;
            
            if(delta>=1){
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000){
                display.getFrame().setTitle("Ticks and Frames : "+ticks);
                //System.out.println("Ticks and Frames : "+ticks);
                ticks = 0;
                timer = 0;
            }
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException ex) {
            }
        }
        
        stop();
        
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    
    
    
    public synchronized void start(){ //STARTS OUR THREAD.Synchronized KEYWORD IS USEDD WHEN WE WORK WITH THREADS DIRECTLY.
        if(running) //INCASE OUR GAME WAS ALREADY RUNNING AND AND BY MISTAKE THIS FN WAS CALLED, INORDER TO AVOID THREADS ERROR WE MADE THIS CNDITION.
            return;
        
        running = true;
        thread = new Thread(this); //THE THREAD RUNS THIS GAME CLASS.
        thread.start(); // IT WILL CALL THE run METHOD.
    }
    
    public synchronized void stop(){  //STOPS OUR THREAD.
        if(!running)
            return;
        running = false;
        try {
        thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
