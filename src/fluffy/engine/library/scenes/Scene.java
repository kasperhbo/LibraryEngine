package fluffy.engine.library.scenes;

import java.util.HashMap;

import fluffy.engine.library.Gameobject;
import fluffy.engine.library.Window;
import fluffy.engine.library.rendering.Camera;
import fluffy.engine.library.rendering.IRenderable;
import fluffy.utils.Vector4;

public abstract class Scene implements IRenderable{
	private String sceneName;
	private static Camera camera = null;
	private HashMap<String, Gameobject> gameobjects = new HashMap<>();
	private Vector4 clearColor = new Vector4(1,1,1, 1);

	public Scene(String sceneName) {
		this.sceneName = sceneName;
		this.camera = new Camera();
	}

	public Scene(String sceneName, Vector4 clearColor) {
		this.sceneName = sceneName;
		this.camera = new Camera();
		this.clearColor = clearColor;
	}
	

	public void addGameobject(Gameobject go) {

		if(gameobjects.containsKey(go.getName()) )
		{
			System.out.println("Pleasse give an unique name to: " + go.getName() + " \n" + " now its not added to the scene.." + "\n" );
			return;
		}

		gameobjects.put(go.getName(), go);
		go.init();
		go.start();
	}
		
	public void update(float dt) {
		gameobjects.forEach((key,value) -> value.update(dt));
	}
	
	@Override
	public void render() {
		Window.getParent().translate(camera.transform.position.x, camera.transform.position.y);
		Window.getParent().background(clearColor.x * 255, clearColor.y * 255, clearColor.z * 255, clearColor.w * 255);

		gameobjects.forEach((key,value) -> value.render());
	}
	
	public void setClearColor(Vector4 clearColor) {
		this.clearColor = clearColor;
	}

	public String getSceneName() {
		return sceneName;
	}
	
	public Gameobject getGameobject(String name) {
		if(gameobjects.containsKey(name)) return null;
		
		return gameobjects.get(name);
	}

	public Camera getCamera(){
		return camera;
	}
}
