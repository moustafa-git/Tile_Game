package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import java.awt.Graphics;

public abstract class State {
  
    private static State currentState = null;
    private static String stateName = null;
    
    public static void setState(State state,String name){
        currentState = state;
        stateName=name;
    }
    public static State getState(){
        return currentState;
    }
    public static String getStateName(){
        return stateName;
    }
    
    protected Handler handler;
    
    public State(Handler handler){
        this.handler =handler;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}
