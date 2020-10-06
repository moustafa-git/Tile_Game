package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Text;
import dev.codenmore.tilegame.scoreboard.ScoreBoard;
import dev.codenmore.tilegame.ui.ClickListner;
import dev.codenmore.tilegame.ui.UIManager;
import dev.codenmore.tilegame.ui.UIPlayButton;
import dev.codenmore.tilegame.ui.UIQuitButton;
import java.awt.Color;
import java.awt.Graphics;

public class EndState extends State{
    
    private ScoreBoard scoreBoard;
    private Handler handler;
    private Display display;
    private UIManager uiManager;
    
     public EndState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        this.handler = handler;
        
        
        /*uiManager.addObject(new UIQuitButton(500,200,168,64,Assets.btn_quit,new ClickListner(){

            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null); //MAKES ALL THE BUTTONS DONT TAKE ANY INPUT ONCE YOU ENTERED THE GAME.
                State.setState(handler.getGame().menuState,"MenuState");
            }
        }));*/
       
        
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gameover,0,0,1200,650,null);
        Text.drawString(g, "GAME OVER", 420, 60, false, Color.black, Assets.font48);
        uiManager.render(g);
        
        Text.drawString(g, "SWORD", 420, 180, false, Color.white, Assets.font28);
        g.drawImage(Assets.dmg1, 580, 150,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getD1(), 640, 180, false, Color.white, null);
        Text.drawString(g, "SWORD", 420, 230, false, Color.yellow, Assets.font28);
        g.drawImage(Assets.dmg2, 580, 200,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getD2(), 640, 230, false, Color.yellow, null);
        
        
        Text.drawString(g, "HEALTH", 420, 280, false, Color.white, Assets.font28);
        g.drawImage(Assets.heal1, 580, 250,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getH1(), 640, 280, false, Color.white, null);
        Text.drawString(g, "HEALTH", 420, 330, false, Color.yellow, Assets.font28);
        g.drawImage(Assets.heal2, 580, 300,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getH2(), 640, 330, false, Color.yellow, null);
        
        Text.drawString(g, "SPEED", 420, 380, false, Color.white, Assets.font28);
        g.drawImage(Assets.speed1, 580, 350,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getS1(), 640, 380, false, Color.white, null);
        Text.drawString(g, "SPEED", 420, 430, false, Color.yellow, Assets.font28);
        g.drawImage(Assets.speed2, 580, 400,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getS2(), 640, 430, false, Color.yellow, null);
        
        Text.drawString(g, "NECKLACE", 420, 480, false, Color.red, Assets.font28);
        g.drawImage(Assets.necklace, 580, 450,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getN(), 640, 480, false, Color.red, null);
        
         Text.drawString(g, "SKELETON", 420, 530, false, Color.white, Assets.font28);
        g.drawImage(Assets.skeleton_idle[0], 580, 500,32,32, null);
        Text.drawString(g, ""+handler.getWorld().getEntityManager().getSkeleton().getCount()+"/1", 640, 530, false, Color.black, null);
        
        Text.drawString(g, "DEMON", 420, 580, false, Color.black, Assets.font28);
        g.drawImage(Assets.demon_idle[0], 580, 550,32,32, null);
        Text.drawString(g, ""+handler.getWorld().getEntityManager().getDemon().getCount()+"/1", 640, 580, false, Color.black, null);
       
    }
}
