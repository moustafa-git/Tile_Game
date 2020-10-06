package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile3 extends Tile{

    public RoofTile3(int id) {
        super(Assets.roof3, id);
    }

   public boolean isSolid(){
        return true;
    }
}