import fluffy.engine.library.*;
import fluffy.engine.library.collisions.*;
import fluffy.engine.library.components.*;
import fluffy.engine.library.rendering.*;
import fluffy.engine.library.scenes.*;
import fluffy.utils.*;
import template.library.*;


void setup(){
    size(800,800);
    Window.get().setParent(this);
    Window.get().addScene(new TestScene("testScene"));
    Window.get().changeScene("testScene");
    
}

void draw(){
  Window.get().loop();
}
