import processing.sound.*;


public class TestScene extends Scene{
  SoundFile file;
  
  public TestScene(String sceneName){
    super(sceneName);
    Player player = new Player("player", new Transform(new Vector2(400,400), new Vector2(50,50)));
    this.addGameobject(player);
    
    addAudio();
  }
  
  private void addAudio(){
    String fileName = "Adventures-in-Adventureland.mp3";
    boolean looping = true;
    PApplet parent = Window.get().getParent();
    AudioSource src = new AudioSource(parent, fileName, looping);
    src.play();
  }
 
  
  @Override
  public void update(float dt){
    super.update(dt);
  }
}
