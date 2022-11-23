package fluffy.engine.library;

import fluffy.engine.library.components.Component;
import fluffy.engine.library.rendering.IRenderable;
import fluffy.utils.Transform;
import fluffy.utils.Vector2;

import java.util.ArrayList;

public class Gameobject implements IRenderable {

	private String name;
	public Transform transform;
	private ArrayList<Component> components = new ArrayList<>();

	public Gameobject(String name, Transform transform)
	{
		this.name = name;
		
		float wWhidth = Window.getParent().width;
		float wHeight = Window.getParent().height;
		
		float mulX  = wWhidth / Window.get().getViewPortProjection().x;
		float mulY  = wHeight / Window.get().getViewPortProjection().y;
				
		float posX = transform.position.x * mulX;
		float posY = transform.position.y * mulY;
		
		float scaleX = transform.size.x * mulX;
		float scaleY = transform.size.y * mulY;
		
		Vector2 pos = new Vector2(posX, posY);
		Vector2 size = new Vector2(scaleX, scaleY);
		
		this.transform = new Transform(pos, size);
		
		
		for (int i=0; i < components.size(); i++) {
			components.get(i).init(this);
		}
	}

	public void init()
	{

	}
	
	public void start()	{
		for (int i=0; i < components.size(); i++) {
			components.get(i).start();
		}
	}

	@Override
	public void render() {
		for (int i=0; i < components.size(); i++) {
			components.get(i).render();
		}
	}

	public void update(float dt) {
		for (int i=0; i < components.size(); i++) {
			components.get(i).update(dt);
		}
	}

	public void setPosition(Vector2 val){
		transform.position = val;
	}

	public void setSize(Vector2 val){
		transform.size = val;
	}

	public <T extends Component> T getComponent(Class<T> componentClass) {
		for (Component c : components) {
			if (componentClass.isAssignableFrom(c.getClass())) {
				try {
					return componentClass.cast(c);
				} catch (ClassCastException e) {
					e.printStackTrace();
					assert false : "Error: Casting component.";
				}
			}
		}

		return null;
	}

	public <T extends Component> void removeComponent(Class<T> componentClass) {
		for (int i=0; i < components.size(); i++) {
			Component c = components.get(i);
			if (componentClass.isAssignableFrom(c.getClass())) {
				components.remove(i);
				return;
			}
		}
	}

	public void addComponent(Component c) {
		this.components.add(c);
		c.init(this);
		c.start();
		System.out.println("adding comp");
	}

	public String getName() {		
		return name;
	}


}
