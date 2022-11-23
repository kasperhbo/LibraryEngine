public class Player extends Gameobject{
  public Player(String name, Transform transform){
    super(name, transform);
  }
  
  @Override
  public void init(){
    SpriteRenderer sprRen = new SpriteRenderer();
    Sprite spr = new Sprite();
    PImage texture = loadImage("apple.png");
    spr.setTexture(texture);
    sprRen.setSprite(spr);
    this.addComponent(sprRen);
  }
  
  @Override
  public void update(float dt){

    super.update(dt);
  }
  
  
  @Override
  public void render(){
    super.render();
  }
}
