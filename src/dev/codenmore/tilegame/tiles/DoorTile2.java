/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author sa7er
 */
public class DoorTile2 extends Tile{

    public DoorTile2(int id) {
        super(Assets.door2, id);
    }
    
    public boolean isSolid(){
        return true;
    }
}
