package dev.codenmore.tilegame.scoreboard;

import com.sun.glass.events.KeyEvent;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Text;
import dev.codenmore.tilegame.items.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class ScoreBoard {
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> scoreBoardItems;

    public ScoreBoard(Handler handler) {
        this.handler = handler;
        scoreBoardItems = new ArrayList<Item>();
        
    }
    
    public void tick(){
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_P))
            active = !active;
        if(!active)
            return;
    }
    
    public void render(Graphics g){
        if(!active)
            return;
        
        g.drawImage(Assets.scoreBoardScreen, 20, 20, 360,590,null);
        
        Text.drawString(g, "SCORE BOARD", 60, 60, false, Color.white, Assets.font32);
        
        Text.drawString(g, "SWORD", 60, 180, false, Color.white, Assets.font28);
        g.drawImage(Assets.dmg1, 220, 150,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getD1(), 280, 180, false, Color.white, null);
        Text.drawString(g, "SWORD", 60, 230, false, Color.yellow, Assets.font28);
        g.drawImage(Assets.dmg2, 220, 200,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getD2(), 280, 230, false, Color.yellow, null);
        
        
        Text.drawString(g, "HEALTH", 60, 280, false, Color.white, Assets.font28);
        g.drawImage(Assets.heal1, 220, 250,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getH1(), 280, 280, false, Color.white, null);
        Text.drawString(g, "HEALTH", 60, 330, false, Color.yellow, Assets.font28);
        g.drawImage(Assets.heal2, 220, 300,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getH2(), 280, 330, false, Color.yellow, null);
        
        Text.drawString(g, "SPEED", 60, 380, false, Color.white, Assets.font28);
        g.drawImage(Assets.speed1, 220, 350,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getS1(), 280, 380, false, Color.white, null);
        Text.drawString(g, "SPEED", 60, 430, false, Color.yellow, Assets.font28);
        g.drawImage(Assets.speed2, 220, 400,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getS2(), 280, 430, false, Color.yellow, null);
        
        Text.drawString(g, "NECKLACE", 60, 480, false, Color.red, Assets.font28);
        g.drawImage(Assets.necklace, 220, 450,32,32, null);
        Text.drawString(g, "X "+handler.getWorld().getItemManager().getN(), 280, 480, false, Color.red, null);
        
        Text.drawString(g, "DEMON", 60, 530, false, Color.blue, Assets.font28);
        g.drawImage(Assets.demon_idle[0], 220, 500,32,32, null);
        Text.drawString(g, ""+handler.getWorld().getEntityManager().getDemon().getCount()+"/1", 280, 530, false, Color.blue, null);
       
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    public void addItem(Item item){
        for(Item i : scoreBoardItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        scoreBoardItems.add(item);
    }
    
}
