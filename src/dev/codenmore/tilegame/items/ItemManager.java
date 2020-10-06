package dev.codenmore.tilegame.items;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.states.entities.creatures.Player;
import dev.codenmore.tilegame.states.entities.creatures.Vampire;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemManager {
    
    private Display display;
    private Handler handler;
    private ArrayList<Item> items;
    
    private int d1,d2,s1,s2,h1,h2,n = 0;

    public ItemManager(Handler handler) {
        this.handler = handler;
        items = new ArrayList<Item>(); 
    }
    
    public void tick(){
     
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i  = it.next();
            i.tick();
            if(i.isPickedUp()){
                it.remove();
                if(handler.getWorld().getEntityManager().getPlayer() != null){
                    if(i.id == 0){//dmg1
                        Player.attckDmg += 5;
                        d1++;
                    }
                    if(i.id == 1){//dmg2
                        Player.attckDmg += 10;
                        d2++;
                    }
                    if(i.id == 2){//speed1
                        Player.speed += 1.0f;
                        s1++;
                    }
                    if(i.id == 3){//speed2
                        Player.speed += 2.0f;
                        s2++;
                    }
                    if(i.id == 4){//health 1
                        Player.health += 15;
                        h1++;
                    }
                    if(i.id == 5){//heal2
                        Player.health += 25;
                        h2++;
                    }
                    if(i.id == 6){//necklace
                        Player.health += 15;
                        Player.attckDmg += 5;
                        Player.speed += 1.0f;
                        n++;
                    }
                }
                else{
                    if(i.id == 0){//dmg1
                        Vampire.attckDmg += 5;
                        d1++;
                    }
                    if(i.id == 1){//dmg2
                        Vampire.attckDmg += 10;
                        d2++;
                    }
                    if(i.id == 2){//speed1
                        Vampire.speed += 1.0f;
                        s1++;
                    }
                    if(i.id == 3){//speed2
                        Vampire.speed += 2.0f;
                        s2++;
                    }
                    if(i.id == 4){//health 1
                        Vampire.health += 15;
                        h1++;
                    }
                    if(i.id == 5){//heal2
                        Vampire.health += 25;
                        h2++;
                    }
                    if(i.id == 6){//necklace
                        Vampire.health += 15;
                        Vampire.attckDmg += 5;
                        Vampire.speed += 1.0f;
                        n++;
                    }
                }
            }  
        }
    }
    
    public void render(Graphics g){
        for(Item i : items)
            i.render(g);
    }
    
    
    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }

    public Handler getHandler() {
        return handler;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public int getS1() {
        return s1;
    }

    public int getS2() {
        return s2;
    }

    public int getH1() {
        return h1;
    }

    public int getH2() {
        return h2;
    }

    public int getN() {
        return n;
    }
    
    
    
}
