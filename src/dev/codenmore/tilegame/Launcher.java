package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;

public class Launcher {
    
    public static void main(String[] args) {
        
        Game game = new Game("SOLOMATE",1200,650);
        game.start();
    }
    
}
