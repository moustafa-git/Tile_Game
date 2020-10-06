package dev.codenmore.tilegame.worlds;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.items.ItemManager;
import dev.codenmore.tilegame.states.CharacterSelection;
import dev.codenmore.tilegame.states.entities.EntityManager;
import dev.codenmore.tilegame.states.entities.creatures.Demon;
import dev.codenmore.tilegame.states.entities.creatures.Player;
import dev.codenmore.tilegame.states.entities.creatures.Skeleton;
import dev.codenmore.tilegame.states.entities.creatures.Vampire;
import dev.codenmore.tilegame.states.entities.statics.Block;
import dev.codenmore.tilegame.states.entities.statics.BlockB;
import dev.codenmore.tilegame.states.entities.statics.BlockW;
import dev.codenmore.tilegame.states.entities.statics.Box;
import dev.codenmore.tilegame.states.entities.statics.Box2;
import dev.codenmore.tilegame.states.entities.statics.BranchTree;
import dev.codenmore.tilegame.states.entities.statics.Bush;
import dev.codenmore.tilegame.states.entities.statics.Chair;
import dev.codenmore.tilegame.states.entities.statics.ClockTree;
import dev.codenmore.tilegame.states.entities.statics.Fence;
import dev.codenmore.tilegame.states.entities.statics.Fountain;
import dev.codenmore.tilegame.states.entities.statics.Tree;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;
import java.awt.Graphics;

public class World implements Runnable{
    
    private int character;
    
    private String path;
    private Handler handler;
    private int width,height;
    public int spawnX,spawnY;
    private int[][] tiles;
    
    //ENTITIES
    private EntityManager entityManager;
    
    //ITEM
    private ItemManager itemManager;
    
    public World(Handler handler,String path,int character){
                
                
        this.handler = handler;
        this.path = path;
        //entityManager = new EntityManager(handler,new Player(handler,200,500),new Demon(handler,2430,45));//PLAYER
        
        this.character = character;
        
        itemManager = new ItemManager(handler);
        entityManager = new EntityManager(handler);

    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        
        tiles = new int[width][height];
        for(int y=0;y<height;y++){
            for(int x =0;x<width;x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
        
        
    }
    
    public void tick(){
        itemManager.tick();
        entityManager.tick();
    }
    
    public void render(Graphics g){
        int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() /Tile.TILE_WIDTH );
        int xEnd =(int) Math.min(width,(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH +1);
        int yStart =(int)Math.max(0, handler.getGameCamera().getyOffset() /Tile.TILE_HEIGHT);
        int yEnd=(int) Math.min(height,(handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILE_HEIGHT +1);
        
        
        
        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++){
                getTile(x,y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        
        //ITEMS
        itemManager.render(g);
        
        //ENTITIES
        entityManager.render(g);
        
    }
    
    
    public Tile getTile(int x,int y){
        if(x<0 || y<0 || x>=width || y>=height)
            return Tile.grassTile;
        
        
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.grassTile;
        return t;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    @Override
    public void run() {
        entityManager.addEntity(new Tree(handler,1075,315));
        entityManager.addEntity(new Tree(handler,2030,315));
        entityManager.addEntity(new Tree(handler,1075,800));
        entityManager.addEntity(new Tree(handler,1800,800));
        entityManager.addEntity(new Tree(handler,1260,1000));
        entityManager.addEntity(new Tree(handler,1570,1000));
        entityManager.addEntity(new Tree(handler,435,1000));
        entityManager.addEntity(new Tree(handler,725,1000));
        entityManager.addEntity(new Tree(handler,2060,1000));
        entityManager.addEntity(new Tree(handler,2320,1000));
        entityManager.addEntity(new Tree(handler,1400,1500));
        
        entityManager.addEntity(new BranchTree(handler,40,115));
        entityManager.addEntity(new BranchTree(handler,1850,320));
        entityManager.addEntity(new BranchTree(handler,1350,600));
        entityManager.addEntity(new BranchTree(handler,1900,1100));
        
        entityManager.addEntity(new ClockTree(handler,750,20));
        entityManager.addEntity(new ClockTree(handler,1650,1035));
        entityManager.addEntity(new ClockTree(handler,550,1250));
        
        entityManager.addEntity(new Bush(handler,0,0));
        entityManager.addEntity(new Bush(handler,750,65));
        entityManager.addEntity(new Bush(handler,700,15));
        entityManager.addEntity(new Bush(handler,40,200));
        entityManager.addEntity(new Bush(handler,135,270));
        entityManager.addEntity(new Bush(handler,1815,405));
        entityManager.addEntity(new Bush(handler,2000,480));
        entityManager.addEntity(new Bush(handler,1640,1100));
        entityManager.addEntity(new Bush(handler,1590,1050));
        entityManager.addEntity(new Bush(handler,1680,1050));
        entityManager.addEntity(new Bush(handler,1830,1300));
        entityManager.addEntity(new Bush(handler,1910,1200));
        entityManager.addEntity(new Bush(handler,2000,1290));
        entityManager.addEntity(new Bush(handler,2860,1710));
        entityManager.addEntity(new Bush(handler,2860,1750));
        entityManager.addEntity(new Bush(handler,2750,1850));
        entityManager.addEntity(new Bush(handler,2400,1850));
        entityManager.addEntity(new Bush(handler,2200,1850));
        entityManager.addEntity(new Bush(handler,1900,1850));
        entityManager.addEntity(new Bush(handler,1600,1850));
        entityManager.addEntity(new Bush(handler,1300,1850));
        entityManager.addEntity(new Bush(handler,1000,1850));
        entityManager.addEntity(new Bush(handler,950,1850));
        entityManager.addEntity(new Bush(handler,0,1850));
        entityManager.addEntity(new Bush(handler,350,1850));
        
        entityManager.addEntity(new Block(handler,1280,355));
        entityManager.addEntity(new Block(handler,1770,355));
        entityManager.addEntity(new Block(handler,1710,300));
        entityManager.addEntity(new Block(handler,1355,300));
        
        entityManager.addEntity(new BlockW(handler,480,590));
        entityManager.addEntity(new BlockW(handler,380,1230));
        entityManager.addEntity(new BlockW(handler,750,1230));
        entityManager.addEntity(new BlockW(handler,750,1520));
        entityManager.addEntity(new BlockW(handler,390,1520));
        entityManager.addEntity(new BlockW(handler,320,1300));
        entityManager.addEntity(new BlockW(handler,820,1300));
        entityManager.addEntity(new BlockW(handler,320,1430));
        entityManager.addEntity(new BlockW(handler,820,1430));
        entityManager.addEntity(new BlockW(handler,2500,370));
        entityManager.addEntity(new BlockW(handler,2500,550));
        
        entityManager.addEntity(new BlockB(handler,650,1625));
        entityManager.addEntity(new BlockB(handler,495,1625));
        entityManager.addEntity(new BlockB(handler,470,1130));
        entityManager.addEntity(new BlockB(handler,685,1130));
        entityManager.addEntity(new BlockB(handler,2155,225));
        entityManager.addEntity(new BlockB(handler,2475,225));

        entityManager.addEntity(new Chair(handler,1205,900));
        entityManager.addEntity(new Chair(handler,1560,900));
        entityManager.addEntity(new Chair(handler,2260,450));
        
        entityManager.addEntity(new Fence(handler,1000,1062));
        entityManager.addEntity(new Fence(handler,1100,1062));
        entityManager.addEntity(new Fence(handler,2460,1062));
        entityManager.addEntity(new Fence(handler,2360,1062));
        entityManager.addEntity(new Fence(handler,1450,1550));
        entityManager.addEntity(new Fence(handler,1550,1550));
        entityManager.addEntity(new Fence(handler,1650,1550));
        entityManager.addEntity(new Fence(handler,1750,1550));
        entityManager.addEntity(new Fence(handler,1850,1550));
        entityManager.addEntity(new Fence(handler,1950,1550));
        entityManager.addEntity(new Fence(handler,2050,1550));
        entityManager.addEntity(new Fence(handler,2150,1550));
        
        entityManager.addEntity(new Fountain(handler,2250,350));
        entityManager.addEntity(new Fountain(handler,90,1350));
        
        entityManager.addEntity(new Box(handler,550,150));
        entityManager.addEntity(new Box(handler,220,755));
        entityManager.addEntity(new Box(handler,100,1600));
        entityManager.addEntity(new Box(handler,1180,1600));
        entityManager.addEntity(new Box(handler,1650,1290));
        entityManager.addEntity(new Box(handler,925,950));
        entityManager.addEntity(new Box(handler,2755,1200));
        entityManager.addEntity(new Box(handler,2400,700));
        entityManager.addEntity(new Box(handler,2780,315));
        
        entityManager.addEntity(new Box2(handler,850,300));
        entityManager.addEntity(new Box2(handler,45,1200));
        entityManager.addEntity(new Box2(handler,830,1640));
        entityManager.addEntity(new Box2(handler,1000,1250));
        entityManager.addEntity(new Box2(handler,2100,1650));
        entityManager.addEntity(new Box2(handler,2700,515));
        
        
        loadWorld(path);
        
        Skeleton skeleton = new Skeleton(handler,2450,140);
        Thread t8 = new Thread(skeleton);
        t8.start();
        
        
        if(this.character == 1){
            Player player = new Player(handler,200,500);
            Thread t5 = new Thread(player);
            t5.start();
        }else{
            Vampire vampire = new Vampire(handler,200,500);
            Thread t7 = new Thread(vampire);
            t7.start();
        }

    }

    public int getCharacter() {
        return character;
    }
    
    
    
}
