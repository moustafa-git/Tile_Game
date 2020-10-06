package dev.codenmore.tilegame.states.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Box2 extends StaticEntity{

    public Box2(Handler handler, float x, float y) {
        super(handler, x, y,160,105);
        
        bounds.x = 5;
        bounds.y = 70;
        bounds.width = 155;
        bounds.height = (int)(height - height/1.5f);
        
        health = 35;
    }


    public void die(){
        
        // create instance of Random class 
        Random rand = new Random();
        int t =rand.nextInt(6);
  
        if( t== 0)
            handler.getWorld().getItemManager().addItem(Item.dmg1.createNew((int)x + 60, (int)y + 60));
        else if(t == 1)
            handler.getWorld().getItemManager().addItem(Item.dmg2.createNew((int)x + 60, (int)y + 60));
        else if(t == 2)
            handler.getWorld().getItemManager().addItem(Item.speed1.createNew((int)x + 60, (int)y + 60));
        else if(t == 3)
            handler.getWorld().getItemManager().addItem(Item.speed2.createNew((int)x + 60, (int)y + 60));
        else if(t == 4)
            handler.getWorld().getItemManager().addItem(Item.heal1.createNew((int)x + 60, (int)y + 60));
        else if(t == 5)
            handler.getWorld().getItemManager().addItem(Item.heal2.createNew((int)x + 60, (int)y + 60));
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.box2, (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height,null);
        
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width,bounds.height);*/
    }
    
}
