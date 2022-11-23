package fluffy.engine.library;

import java.util.HashMap;

import fluffy.engine.library.scenes.Scene;
import fluffy.utils.Time;
import fluffy.utils.Vector2;
import processing.core.PApplet;
import processing.core.PGraphics;

public class Window {

	private static Window window = null;
	private static PApplet parent = null;

	private static HashMap<String, Scene> scenes = new HashMap<>();
	private static Scene currentScene = null;	
	
	private final Vector2 worldSize = new Vector2(1920, 1080);
	
	float beginTime;
    float endTime;
    float dt;
		
    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
        }        
        return Window.window;
    }

	public void setParent(PApplet parent){
		this.parent = parent;
	}

	public static PApplet getParent()
	{
		return parent;
	}

	public Window() {		
        beginTime = Time.getTime();
        dt = -1.0f;
	}
	
    public static boolean changeScene(String sceneName) {
    	if(!scenes.containsKey(sceneName)) 
    		return false;
    	
    	currentScene = scenes.get(sceneName);    	
		return true;    	
    }
    
    public boolean addScene(Scene scene) {
    	if(scenes.containsKey(scene.getSceneName()))
    		return false;
		
    	scenes.put(scene.getSceneName(), scene);
    	return true;
    }
    
    public void loop() {
		if (parent == null) {
			System.out.println("Please set parent on window object using Window.get().setParent(this) in the setup of your application!");
			return;
		}

		if (currentScene != null) {
			if (dt >= 0) {
				currentScene.update(dt);
			}

			currentScene.render();
		}

		endTime = Time.getTime();
		dt = endTime - beginTime;
		beginTime = endTime;
	}

	public Vector2 getViewPortProjection() {
		return worldSize;
	}
}
