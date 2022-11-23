package fluffy.engine.library.components;

import fluffy.engine.library.Window;
import fluffy.utils.Transform;
import processing.core.PImage;

public class SpriteRenderer extends Component{

	private Sprite sprite = new Sprite();
	private transient Transform lastTransform;
	private transient boolean isDirty = true;


	@Override
	public void start() {
		this.lastTransform = gameobject.transform.copy();
	}

	@Override
	public void update(float dt) {
		if (!this.lastTransform.equals(this.gameobject.transform)) {
			this.gameobject.transform.copy(this.lastTransform);
			isDirty = true;
		}
	}

	@Override
	public void render() {
		if (this.sprite.getTexture() != null) {			
			Transform t = this.gameobject.transform;
			Window.getParent().image(sprite.getTexture(), t.position.x, t.position.y, t.size.x, t.size.y);
		}
		else
		{
		}
	}

	public void setDirty() {
		this.isDirty = true;
	}

	public PImage getTexture() {
		return sprite.getTexture();
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
		this.isDirty = true;
	}

	public boolean isDirty() {
		return this.isDirty;
	}

	public void setClean() {
		this.isDirty = false;
	}

	public void setTexture(PImage texture) {
		this.sprite.setTexture(texture);
	}
	
}
