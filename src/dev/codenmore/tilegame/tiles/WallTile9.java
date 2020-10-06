package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile9 extends Tile{

    public WallTile9(int id) {
        super(Assets.wall9, id);
    }

   public boolean isSolid(){
        return true;
    }
}