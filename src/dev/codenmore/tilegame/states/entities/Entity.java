package dev.codenmore.tilegame.states.entities;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import static dev.codenmore.tilegame.states.entities.creatures.Creature.DEFAULT_HEALTH;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class  Entity {
    
    protected Rectangle bounds;
    public static final int DEFAULT_HEALTH =50;
    
    protected int health;
    protected boolean active = true;
    protected Handler handler;
    protected float x,y;
    protected int width,height;
    
    public Entity(Handler handler,float x, float y,int width,int height){
        this.handler =handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        health = DEFAULT_HEALTH;
        
        bounds = new Rectangle(0,0,width,height);
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public void die(){
    }
    
    public void hurt(int amt){
        health -= amt;
        if(health <= 0){
            active = false;
            die();
        }
    }
    
    
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))){
                return true;
            }
        }
        return false;
    }
    
    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x + bounds.x + xOffset),(int)(y + bounds.y + yOffset),bounds.width,bounds.height);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    
    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
