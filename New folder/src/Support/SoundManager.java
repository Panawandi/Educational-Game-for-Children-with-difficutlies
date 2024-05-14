package Support;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager {

    static boolean correct;
    static boolean incorrect;
    static boolean backMusic;

    final static String path = "sounds/";

    public final static Clip[] quiz = new Clip[5];

    public final static Clip isCorrect = getClip("correct");
    public final static Clip isInCorrect = getClip("incorrect");
    public final static Clip bgMusic = getClip("music");

    public final static Clip[] clips = {bgMusic};

    public static void main(String[] args) throws InterruptedException {
        for (Clip clip : clips){
            play(clip);
            Thread.sleep(1000);
        }
    }

    public static void play(Clip clip) {
        clip.start();
    }

    private static Clip getClip(String filename){
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream sample = AudioSystem.getAudioInputStream(new File(path + filename + ".wav"));
            clip.open(sample);
        } catch (Exception e){
            e.printStackTrace();
        } return clip;
    }

    public static void startMusic(){
        if (!backMusic){
            bgMusic.loop(1);
            backMusic = true;
        }
    }

    public static void setIsCorrect(){
        if (!correct){
            isCorrect.loop(0);
            correct = true;
        }
    }

    public static void setIncorrect(){
        if (!incorrect){
            isInCorrect.loop(0);
            incorrect = true;
        }
    }
}
