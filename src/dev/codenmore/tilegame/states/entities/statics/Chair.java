package dev.codenmore.tilegame.states.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class Chair extends StaticEntity{

    public Chair(Handler handler, float x, float y) {
        super(handler, x, y,160,110);
        
        bounds.x = 7;
        bounds.y = 70;
        bounds.width = 140;
        bounds.height = (int)(height - height/1.5f);
        
        health = 10000;
    }



    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.chair, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
        
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width,bounds.height);*/
    }
    
}
