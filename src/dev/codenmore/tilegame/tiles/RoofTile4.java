package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile4 extends Tile{

    public RoofTile4(int id) {
        super(Assets.roof4, id);
    }

   public boolean isSolid(){
        return true;
    }
}