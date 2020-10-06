package dev.codenmore.tilegame.items;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item {
    
    
    protected Rectangle bounds;
    
    //ITEM HANDLER
    public static Item[] items = new Item[256];
    public static Item dmg1 = new Item(Assets.dmg1,"dmg1",0);
    public static Item dmg2 = new Item(Assets.dmg2,"dmg2",1);
    
    public static Item speed1 = new Item(Assets.speed1,"speed1",2);
    public static Item speed2 = new Item(Assets.speed2,"speed2",3);
    
    public static Item heal1 = new Item(Assets.heal1,"health1",4);
    public static Item heal2 = new Item(Assets.heal2,"health2",5);
    
    public static Item necklace = new Item(Assets.necklace,"necklace",6);
    
    
    //CLASS
    public static final int ITEMWIDTH = 32,ITEMHEIGHT=32;
    
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id ;
    
    protected int x,y,count;
    protected boolean pickedUp = false;

    public Item(BufferedImage texture, String name, int id) {
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;
        
        bounds = new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT  );
        
        items[id] = this;
        
    }
    
    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer() != null){
            if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
                pickedUp = true;
                handler.getWorld().getEntityManager().getPlayer().getScoreBoard().addItem(this);  
            }
        }else{
            if(handler.getWorld().getEntityManager().getVampire().getCollisionBounds(0f, 0f).intersects(bounds)){
                pickedUp = true;
                handler.getWorld().getEntityManager().getVampire().getScoreBoard().addItem(this);  
            }
        }
    }
    
    public void render(Graphics g){
        if(handler == null)
            return;
        render(g,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()));
    }
    
    public void render(Graphics g,int x, int y){ //FOR INVENTORY STUFF 
        g.drawImage(texture, x, y,ITEMWIDTH,ITEMHEIGHT,null);
    }

    
    public Item createNew(int count){
        Item i = new Item(texture,name,id);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }
    
    
    public Item createNew(int x, int y){
        Item i = new Item(texture,name,id);
        i.setPosition(x, y);
        return i;
    }
    
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
        bounds.x =x;
        bounds.y = y;
    }
    
    
    //GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public int getId() {
        return id;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
    
    
    
    
    
}
