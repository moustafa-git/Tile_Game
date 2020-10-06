package dev.codenmore.tilegame.states.entities.creatures;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.scoreboard.ScoreBoard;
import dev.codenmore.tilegame.states.EndState;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.states.entities.Entity;
import dev.codenmore.tilegame.states.entities.EntityManager;
import static dev.codenmore.tilegame.states.entities.creatures.Demon.health;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;

public class Player extends Creature implements Runnable{
    
    EntityManager entityManager;
    
    private State endState;
    
    public static int attckDmg = 10;
    public static float speed = 6.0f;
    public static int health = 50;
    
    //SCOREBOARD
    private ScoreBoard scoreBoard;
    
    //ANIMATIONS
    private Animation animIdle,animRunDown,animRunLeft,animRunRight,animRunUp,animSliceDown,animSliceLeft,animSliceRight,animSliceUp;
    
    //ATTACK TIMER
    private long lastAttackTimer,attackCooldown = 350,attackTimer = attackCooldown;

    public Player(Handler handler,float x, float y) {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x=40;
        bounds.y=65;
        bounds.width=40;
        bounds.height=50;
        
        
        //ANIMATIONS
        animIdle = new Animation(180,Assets.player_idle);
        animRunDown = new Animation(100,Assets.player_run_down);
        animRunLeft = new Animation(100,Assets.player_run_left);
        animRunRight = new Animation(100,Assets.player_run_right);
        animRunUp = new Animation(100,Assets.player_run_up);
        animSliceDown = new Animation(120,Assets.player_slice_down);
        animSliceLeft = new Animation(120,Assets.player_slice_left);
        animSliceRight = new Animation(120,Assets.player_slice_right);
        animSliceUp = new Animation(120,Assets.player_slice_up);
        
        scoreBoard = new ScoreBoard(handler);
        
    }
    
    @Override
    public void tick() {
        //ANIMATIONS
        animIdle.tick();
        animRunDown.tick();
        animRunLeft.tick();
        animRunRight.tick();
        animRunUp.tick();
        animSliceDown.tick();
        animSliceLeft.tick();
        animSliceRight.tick();
        animSliceUp.tick();

        //MOVEMENT
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        
        //ATTACK
        checkAttacks();
        
        //SCOREBOARD
        scoreBoard.tick();
    }
    
    
    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;
        
        
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 32;
        ar.width =arSize;
        ar.height=arSize;
        
        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width/2 - arSize/2;
            ar.y = cb.y - arSize;
        }else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width/2 - arSize/2;
            ar.y = cb.y + cb.height;
        }else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height/2 - arSize/2;
        }else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height/2 - arSize/2;
        }else{
            return;
        }
        
        attackTimer = 0;
        
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                e.hurt(attckDmg);
                    return;
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
        System.out.println("YOU LOSE");
        State.setState(new EndState(handler), "EndState");
    }
    
    private void getInput(){
        xMove=0;
        yMove=0;
        
        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().right)
            xMove = speed;
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()),width,height, null);
    
        /*g.setColor(Color.red);
        g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
                (int)(y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width,bounds.height);*/
        
        //HEALTH
        if((int)(this.health*(100.0f/50.0f)) >90){
            g.drawImage(Assets.p100, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 90 && (int)(this.health*(100.0f/50.0f)) > 80){
            g.drawImage(Assets.p90, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 80 && (int)(this.health*(100.0f/50.0f)) > 70){
            g.drawImage(Assets.p80, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 70 && (int)(this.health*(100.0f/50.0f)) > 60){
             g.drawImage(Assets.p70, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 60 && (int)(this.health*(100.0f/50.0f)) > 50){
             g.drawImage(Assets.p60, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 50 && (int)(this.health*(100.0f/50.0f)) > 40){
             g.drawImage(Assets.p50, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 40 && (int)(this.health*(100.0f/50.0f)) > 30){
             g.drawImage(Assets.p40, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 30 && (int)(this.health*(100.0f/50.0f)) > 20){
             g.drawImage(Assets.p30, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 20 && (int)(this.health*(100.0f/50.0f)) > 10){
             g.drawImage(Assets.p20, (int)(0), (int)(5),250,50, null);
        }
        else if((int)(this.health*(100.0f/50.0f)) <= 10 && (int)(this.health*(100.0f/50.0f)) > 0){
             g.drawImage(Assets.p10, (int)(0), (int)(5),250,50, null);
        }
        else{
            g.drawImage(Assets.p0, (int)(0), (int)(5),250,50, null);
        }
    }
    
    
    public void postRender(Graphics g){
                
        //SCOREBOARD
        scoreBoard.render(g);
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            if(handler.getKeyManager().aLeft)
                return animSliceLeft.getCurrentFrame();
            if(handler.getKeyManager().aRight)
                return animSliceRight.getCurrentFrame();
            if(handler.getKeyManager().aUp)
                return animSliceUp.getCurrentFrame();
            if(handler.getKeyManager().aDown)
                return animSliceDown.getCurrentFrame();
            return animRunLeft.getCurrentFrame();
        }else if(xMove > 0){
            if(handler.getKeyManager().aLeft)
                return animSliceLeft.getCurrentFrame();
            if(handler.getKeyManager().aRight)
                return animSliceRight.getCurrentFrame();
            if(handler.getKeyManager().aUp)
                return animSliceUp.getCurrentFrame();
            if(handler.getKeyManager().aDown)
                return animSliceDown.getCurrentFrame();
            return animRunRight.getCurrentFrame();
        }else if(yMove < 0){
            if(handler.getKeyManager().aLeft)
                return animSliceLeft.getCurrentFrame();
            if(handler.getKeyManager().aRight)
                return animSliceRight.getCurrentFrame();
            if(handler.getKeyManager().aUp)
                return animSliceUp.getCurrentFrame();
            if(handler.getKeyManager().aDown)
                return animSliceDown.getCurrentFrame();
            return animRunUp.getCurrentFrame();
        }else if(yMove > 0){
            if(handler.getKeyManager().aLeft)
                return animSliceLeft.getCurrentFrame();
            if(handler.getKeyManager().aRight)
                return animSliceRight.getCurrentFrame();
            if(handler.getKeyManager().aUp)
                return animSliceUp.getCurrentFrame();
            if(handler.getKeyManager().aDown)
                return animSliceDown.getCurrentFrame();
            return animRunDown.getCurrentFrame();
        }else{
            if(handler.getKeyManager().aLeft)
                return animSliceLeft.getCurrentFrame();
            if(handler.getKeyManager().aRight)
                return animSliceRight.getCurrentFrame();
            if(handler.getKeyManager().aUp)
                return animSliceUp.getCurrentFrame();
            if(handler.getKeyManager().aDown)
                return animSliceDown.getCurrentFrame();
            return animIdle.getCurrentFrame();}
        
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    @Override
    public void run() {
        handler.getWorld().getEntityManager().addPlayer(handler, this);
        this.setX(handler.getWorld().spawnX);
        this.setY(handler.getWorld().spawnY);
    }
    
    
    
}
