package dev.codenmore.tilegame.states.entities;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.states.entities.creatures.Demon;
import dev.codenmore.tilegame.states.entities.creatures.Player;
import dev.codenmore.tilegame.states.entities.creatures.Skeleton;
import dev.codenmore.tilegame.states.entities.creatures.Vampire;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private Demon demon;
    private Vampire vampire;
    private Skeleton skeleton;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){

        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight()){
                return -1;
            }
            return 1;
        }
        
    };
    
    public EntityManager(Handler handler,Player player,Demon demon) {
        this.handler = handler;
        this.player = player;
        this.demon = demon;
        entities = new ArrayList<Entity>();
        addEntity(player);
        addEntity(demon);
    }

    public EntityManager(Handler handler) {
        this.handler = handler;
        entities = new ArrayList<Entity>();
    }
    
    
    public void addPlayer(Handler handler,Player player){
        this.handler = handler;
        this.player = player;
        addEntity(player);
    }
    
     public void addVampire(Handler handler,Vampire vampire){
        this.handler = handler;
        this.vampire = vampire;
        addEntity(vampire);
    }
    
    public void addDemon(Handler handler,Demon demon){
        this.handler = handler;
        this.demon = demon;
        addEntity(demon);
    }
    
    public void addSkeleton(Handler handler,Skeleton skeleton){
        this.handler = handler;
        this.skeleton = skeleton;
        addEntity(skeleton);
    }
    
    public void tick(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();
            e.tick();
            if(!e.isActive())
                it.remove();
        }
        
        entities.sort(renderSorter);
    }
    
    public void render(Graphics g){ 
        for(Entity e : entities){
            e.render(g);
        }
        //player.postRender(g);
    }

    
    public void addEntity(Entity e){
        entities.add(e);
    }
    
    
    
    //GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Demon getDemon() {
        return demon;
    }

    public void setDemon(Demon demon) {
        this.demon = demon;
    }

    public Vampire getVampire() {
        return vampire;
    }

    public Skeleton getSkeleton() {
        return skeleton;
    }

    
    
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
    
    
    
}
