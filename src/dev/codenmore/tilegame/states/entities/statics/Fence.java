package dev.codenmore.tilegame.states.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class Fence extends StaticEntity{

    public Fence(Handler handler, float x, float y) {
        super(handler, x, y,100,110);
        
        bounds.x = 7;
        bounds.y = 87;
        bounds.width = 100;
        bounds.height = 18;
        
        health = 10000;
    }


    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.fence, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
        
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width,bounds.height);*/
    }
    
}
