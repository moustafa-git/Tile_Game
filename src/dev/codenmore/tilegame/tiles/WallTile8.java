package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile8 extends Tile{

    public WallTile8(int id) {
        super(Assets.wall8, id);
    }

   public boolean isSolid(){
        return true;
    }
}