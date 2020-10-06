package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WallTile3 extends Tile{

    public WallTile3(int id) {
        super(Assets.wall3, id);
    }

   public boolean isSolid(){
        return true;
    }
}