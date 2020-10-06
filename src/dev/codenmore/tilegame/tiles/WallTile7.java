package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile7 extends Tile{

    public WallTile7(int id) {
        super(Assets.wall7, id);
    }

   public boolean isSolid(){
        return true;
    }
}