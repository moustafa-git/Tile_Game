package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile2 extends Tile{

    public WallTile2(int id) {
        super(Assets.wall2, id);
    }

   public boolean isSolid(){
        return true;
    }
}