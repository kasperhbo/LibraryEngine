import fluffy.engine.library.*;
import fluffy.engine.library.collisions.*;
import fluffy.engine.library.components.*;
import fluffy.engine.library.rendering.*;
import fluffy.engine.library.scenes.*;
import fluffy.utils.*;
import template.library.*;

void settings(){
  
  int sizeX = 1920;
  int sizeY = 1080;
  
  size(sizeX,sizeY);
}

void setup(){
   
    Window.get().setParent(this);
    Window.get().addScene(new TestScene("testScene"));
    Window.get().changeScene("testScene"); 
}

void draw(){
  Window.get().loop();
}
