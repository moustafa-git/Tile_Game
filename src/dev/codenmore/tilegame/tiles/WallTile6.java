package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile6 extends Tile{

    public WallTile6(int id) {
        super(Assets.wall6, id);
    }

   public boolean isSolid(){
        return true;
    }
}