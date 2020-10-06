package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile7 extends Tile{

    public RoofTile7(int id) {
        super(Assets.roof7, id);
    }

   public boolean isSolid(){
        return true;
    }
}