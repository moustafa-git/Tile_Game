package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile5 extends Tile{

    public WallTile5(int id) {
        super(Assets.wall5, id);
    }

   public boolean isSolid(){
        return true;
    }
}