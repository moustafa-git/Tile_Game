package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WindowTile2 extends Tile{

    public WindowTile2(int id) {
        super(Assets.window2, id);
    }

   public boolean isSolid(){
        return true;
    }
}