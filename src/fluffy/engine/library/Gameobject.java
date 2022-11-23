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
		this.transform = transform;
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
