package dev.codenmore.tilegame.music;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.states.entities.creatures.Demon;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MenuThemeThread implements Runnable{

    private int i;
    Display display;
    
    @Override
    public void run() {
             for(;;){
                if(State.getStateName() =="MenuState"){
                break;
                }                  
            }
             
            try{
            File musicpath = new File("res\\music\\menu theme.wav");
            
            if(musicpath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                for(;;){
                    try {
                        Thread.sleep(1);
                    }
                        catch (InterruptedException ex) {
                    }
                    if(State.getStateName() !="MenuState" && State.getStateName() !="CharacterSelection"){
                        clip.stop();
                        break;
                    }
                }
            }
            else
                System.out.println("Can't find file");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
