package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile2 extends Tile{

    public RoofTile2(int id) {
        super(Assets.roof2, id);
    }

   public boolean isSolid(){
        return true;
    }
}