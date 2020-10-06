package dev.codenmore.tilegame.states.entities.creatures;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;
import dev.codenmore.tilegame.states.entities.Entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Skeleton extends Creature implements Runnable{
    Entity e;

    private int count=0;
    public static int attckDmg = 5;
    public static int health = 100;
    
    //ANIMATIONS
     private Animation animIdle,animAttack;
     
     //ATTACK TIMER
    private long lastAttackTimer,attackCooldown = 1400,attackTimer = attackCooldown; //increase to slow
    
    
    
    
    public Skeleton(Handler handler, float x, float y) {
        super(handler, x, y,50,80);
        
        bounds.x=20;
        bounds.y=25;
        bounds.width=40;
        bounds.height=80;
        
        //ANIMATIONS
        animIdle = new Animation(90,Assets.skeleton_idle);
        animAttack = new Animation(50,Assets.skeleton_attack);
        
    }
    
    @Override
    public void tick() {
        //ANIMATIONS
        animIdle.tick();
        animAttack.tick();

        
        //ATTACK
        checkAttacks();
    }
    
    
    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;
        
        
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 64;
        ar.width =arSize;
        ar.height=arSize;
        
        ar.x = cb.x - arSize;
        ar.y = cb.y + cb.height/2 - arSize/2;
        
        attackTimer = 0;
        
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                if(e.equals(handler.getWorld().getEntityManager().getPlayer())){
                    handler.getWorld().getEntityManager().getPlayer().hurt(attckDmg);
                }
                else if(e.equals(handler.getWorld().getEntityManager().getVampire())){
                    handler.getWorld().getEntityManager().getVampire().hurt(attckDmg);
                }
                else{
                     e.hurt(attckDmg);
                    return;
                }
            }
            
        }
    }

    public void hurt(int amt){
        health -= amt;
        if(health <= 0){
            active = false;
            die();
        }
    }
    
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.necklace.createNew((int)x + 60, (int)y + 60));
        count++;
        Demon demon = new Demon(handler,2430,45);
        Thread t6 = new Thread(demon);
        t6.start();
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
    
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width,bounds.height);*/
        
        //HEALTH
        if((int)(this.health*(100.0f/100.0f)) <= 100 && (int)(this.health*(100.0f/100.0f)) > 83){
            g.drawImage(Assets.h100, (int)(x - handler.getGameCamera().getxOffset() + 15), (int)(y - handler.getGameCamera().getyOffset()),100,15, null);
        }
        else if((int)(this.health*(100.0f/100.0f)) <= 83 && (int)(this.health*(100.0f/100.0f)) > 67){
            g.drawImage(Assets.h83, (int)(x - handler.getGameCamera().getxOffset() + 15), (int)(y - handler.getGameCamera().getyOffset()),100,15, null);
        }
        else if((int)(this.health*(100.0f/100.0f)) <= 67 && (int)(this.health*(100.0f/100.0f)) > 50){
            g.drawImage(Assets.h67, (int)(x - handler.getGameCamera().getxOffset() + 15), (int)(y - handler.getGameCamera().getyOffset()),100,15, null);
        }
        else if((int)(this.health*(100.0f/100.0f)) <= 50 && (int)(this.health*(100.0f/100.0f)) > 33){
             g.drawImage(Assets.h50, (int)(x - handler.getGameCamera().getxOffset() + 15), (int)(y - handler.getGameCamera().getyOffset()),100,15, null);
        }
        else if((int)(this.health*(100.0f/100.0f)) <= 33 && (int)(this.health*(100.0f/100.0f)) > 17){
             g.drawImage(Assets.h33, (int)(x - handler.getGameCamera().getxOffset() + 15), (int)(y - handler.getGameCamera().getyOffset()),100,15, null);
        }
        else{
            g.drawImage(Assets.h17, (int)(x - handler.getGameCamera().getxOffset() + 15), (int)(y - handler.getGameCamera().getyOffset()),100,15, null);
        }
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 64;
        ar.width =arSize;
        ar.height=arSize;
        
        
        ar.x = cb.x - arSize;
        ar.y = cb.y + cb.height/2 - arSize/2;
        
        
        
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                return animAttack.getCurrentFrame();
            }
            
        }
        return animIdle.getCurrentFrame();
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
         handler.getWorld().getEntityManager().addSkeleton(handler, this);
    }
    
    
}
