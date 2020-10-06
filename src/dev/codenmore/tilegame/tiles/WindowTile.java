package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

public class WindowTile extends Tile{

    public WindowTile(int id) {
        super(Assets.window, id);
    }

   public boolean isSolid(){
        return true;
    }
}