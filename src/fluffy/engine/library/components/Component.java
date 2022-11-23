package fluffy.engine.library.components;

import fluffy.engine.library.Gameobject;
import fluffy.engine.library.rendering.IRenderable;

public abstract class Component implements IRenderable {
	
	protected Gameobject gameobject = null;
	
	public void init(Gameobject parent) {
		this.gameobject = parent;
	}

	public void start() {
	}
	
	public abstract void update(float dt);
	
	@Override
	public abstract void render();
}
