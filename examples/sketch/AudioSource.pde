import processing.sound.SoundFile;

public class AudioSource{
    String filePath = "";

    SoundFile sound;

    boolean loop = false;

    public AudioSource(PApplet p, String filePath){
        this.filePath = filePath;
        sound = new SoundFile(p, filePath);
    }

    public AudioSource(PApplet p, String filePath, boolean looping){
        this.filePath = filePath;
        this.loop = looping;
        sound = new SoundFile(p, filePath);
    }

    public void play(){
        if(this.isPlaying())
            sound.stop();
        if(this.loop){
            sound.loop();
        }else{
            sound.play();
        }
    }

    public void stop(){
        sound.stop();
    }

    public boolean isPlaying(){
        return sound.isPlaying();
    }
}
