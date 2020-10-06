package dev.codenmore.tilegame.music;

import dev.codenmore.tilegame.states.State;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EndThemeThread  implements Runnable{

@Override
    public void run() {
        //System.out.println("hooo");
   
        for(;;){
            if(State.getStateName() =="EndState"){
            break;
            }                  
        }
        
            try{
            File musicpath = new File("res\\music\\gameover.wav");
            
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
                    if(State.getStateName() !="EndState"){
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
