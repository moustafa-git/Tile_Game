package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.states.entities.creatures.Player;
import dev.codenmore.tilegame.states.entities.statics.Tree;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.worlds.World;
import java.awt.Graphics;

public class GameState extends State{
    
    
    private World world;
    
    public GameState(Handler handler, int character){
        super(handler);
        world = new World(handler,"res/worlds/world1.txt",character);
        handler.setWorld(world);
        Thread wrld = new Thread(world);
        wrld.start();
        try{
            wrld.join();
        }
        catch(Exception e){
            System.out.println("error");
        }
        
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    
    
}
