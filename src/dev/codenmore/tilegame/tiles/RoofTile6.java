package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile6 extends Tile{

    public RoofTile6(int id) {
        super(Assets.roof6, id);
    }

   public boolean isSolid(){
        return true;
    }
}