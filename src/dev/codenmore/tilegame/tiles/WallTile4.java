package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile4 extends Tile{

    public WallTile4(int id) {
        super(Assets.wall4, id);
    }

   public boolean isSolid(){
        return true;
    }
}