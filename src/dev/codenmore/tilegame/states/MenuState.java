package dev.codenmore.tilegame.states;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListner;
import dev.codenmore.tilegame.ui.UIManager;
import dev.codenmore.tilegame.ui.UIPlayButton;
import dev.codenmore.tilegame.ui.UIQuitButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import javax.swing.JFrame;


public class MenuState extends State{
    
    
    private Display display;
    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        
        
        uiManager.addObject(new UIPlayButton(500,200,168,64,Assets.btn_play,new ClickListner(){

            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null); //MAKES ALL THE BUTTONS DONT TAKE ANY INPUT ONCE YOU ENTERED THE GAME.
                State.setState(new CharacterSelection(handler), "CharacterSelection");
            }
        }));
       
        
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu,0,0,1200,650,null);
        uiManager.render(g);
    }
    

}
