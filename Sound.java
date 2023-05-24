import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {

    public static void playSound(File Sound){
        try{
            Clip sounds = AudioSystem.getClip();
            sounds.open(AudioSystem.getAudioInputStream(Sound));
            sounds.start();
        }catch (Exception exception)

        {
        }
    }    
}
