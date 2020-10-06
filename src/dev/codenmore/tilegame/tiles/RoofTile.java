package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class RoofTile extends Tile{

    public RoofTile(int id) {
        super(Assets.roof, id);
    }

   public boolean isSolid(){
        return true;
    }
}