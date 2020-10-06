package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile10 extends Tile{

    public WallTile10(int id) {
        super(Assets.wall10, id);
    }

   public boolean isSolid(){
        return true;
    }
}