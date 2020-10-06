package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
    
    //STATIC STUFF
    
    public static Tile[] tiles = new Tile[256];
    
    public static Tile grassTile = new GrassTile(0);
    public static Tile grassTile2 = new GrassTile2(12);
    public static Tile grassTile3 = new GrassTile3(13);
    
    public static Tile roofTile = new RoofTile(14);
    public static Tile roofTile2 = new RoofTile2(15);
    public static Tile roofTile3 = new RoofTile3(16);
    public static Tile roofTile4 = new RoofTile4(17);
    public static Tile roofTile5 = new RoofTile5(18);
    public static Tile roofTile6 = new RoofTile6(19);
    public static Tile roofTile7 = new RoofTile7(20);
    
    public static Tile wallTile = new WallTile(21);
    public static Tile wallTile2 = new WallTile2(22);
    public static Tile wallTile3 = new WallTile3(23);
    public static Tile wallTile4 = new WallTile4(24);
    public static Tile wallTile5 = new WallTile5(25);
    public static Tile wallTile6 = new WallTile6(26);
    public static Tile wallTile7 = new WallTile7(27);
    public static Tile wallTile8 = new WallTile8(28);
    public static Tile wallTile9 = new WallTile9(29);
    public static Tile wallTile10 = new WallTile10(30);
    
    public static Tile windowTile = new WindowTile(31);
    public static Tile windowTile2 = new WindowTile2(32);
    
    public static Tile doorTile = new DoorTile(33);
    public static Tile doorTile2 = new DoorTile2(34);
    
    public static Tile lakeTile = new LakeTile(35);
    public static Tile lakeTile2 = new LakeTile2(36);
    public static Tile lakeTile3 = new LakeTile3(37);
    public static Tile lakeTile4 = new LakeTile4(38);
    public static Tile lakeTile5 = new LakeTile5(39);
    public static Tile lakeTile6 = new LakeTile6(40);
    
    public static Tile stairTile = new StairTile(41);
    
    public static Tile roadTile = new RoadTile(1);
    public static Tile roadTile2 = new RoadTile2(2);
    public static Tile roadTile3 = new RoadTile3(3);
    public static Tile roadTile4 = new RoadTile4(4);
    public static Tile roadTile5 = new RoadTile5(5);
    public static Tile roadTile6 = new RoadTile6(6);
    public static Tile roadTile7 = new RoadTile7(7);
    public static Tile roadTile8 = new RoadTile8(8);
    public static Tile roadTile9 = new RoadTile9(9);
    public static Tile roadTile10 = new RoadTile10(10);
    public static Tile roadTile11 = new RoadTile11(11);
    
    
    
    
    //CLASS
    public static final int TILE_WIDTH = 40,TILE_HEIGHT=40;
    
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture,int id) {
        this.texture=texture;
        this.id=id;
        
        tiles[id]=this;
    }

    
    public void tick(){
    }
    
    public void render(Graphics g,int x,int y){
        g.drawImage(texture, x, y,TILE_WIDTH,TILE_HEIGHT, null);
    }
    
    
    public boolean isSolid(){
        return false;
    }
    
    public int getId() {
        return id;
    }
    
    
}
