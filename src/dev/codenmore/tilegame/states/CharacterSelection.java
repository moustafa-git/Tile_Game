package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListner;
import dev.codenmore.tilegame.ui.UIManager;
import dev.codenmore.tilegame.ui.UIPlayButton;
import dev.codenmore.tilegame.ui.UIVikingButton;
import dev.codenmore.tilegame.worlds.World;
import java.awt.Graphics;

public class CharacterSelection extends State{
    
    
    private UIManager uiManager;

    public CharacterSelection(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        
        uiManager.addObject(new UIVikingButton(0,0,600,650,Assets.btn_viking,new ClickListner(){

            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null); //MAKES ALL THE BUTTONS DONT TAKE ANY INPUT ONCE YOU ENTERED THE GAME.
                State.setState(new GameState(handler,1), "GameState");
            }
        }));
        
        uiManager.addObject(new UIVikingButton(600,0,600,650,Assets.btn_vampire,new ClickListner(){

            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null); //MAKES ALL THE BUTTONS DONT TAKE ANY INPUT ONCE YOU ENTERED THE GAME.
                State.setState(new GameState(handler,2), "GameState");
            }
        }));
        
    }

    
    
    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.viking,0,0,650,650,null);
        uiManager.render(g);
    }

    
    
}
