package dev.codenmore.tilegame.states.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class ClockTree extends StaticEntity{

    public ClockTree(Handler handler, float x, float y) {
        super(handler, x, y,120,290);
        
        bounds.x = 20;
        bounds.y = 200;
        bounds.width = 95;
        bounds.height = 65;
        
        health = 10000;
    }


    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree3, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
        
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width,bounds.height);*/
    }
    
}
