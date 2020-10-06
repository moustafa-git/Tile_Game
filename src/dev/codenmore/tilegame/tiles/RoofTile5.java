package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile5 extends Tile{

    public RoofTile5(int id) {
        super(Assets.roof5, id);
    }

   public boolean isSolid(){
        return true;
    }
}