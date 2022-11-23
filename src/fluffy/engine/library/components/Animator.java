package fluffy.engine.library.components;

import fluffy.engine.library.Gameobject;

public class Animator extends Component{

	AnimationState currentState = null;

	public void init(Gameobject parent, AnimationState animationState) {
		super.init(parent);
		this.currentState = animationState;
	}

	
	@Override
	public void render() {
		if (currentState != null) {
			currentState.render();
		}
	}

	@Override
	public void update(float dt) {
		if (currentState != null) {
			currentState.update(dt);
			SpriteRenderer sprite = gameobject.getComponent(SpriteRenderer.class);
			if (sprite != null) {
				sprite.setSprite(currentState.getCurrentSprite());
				sprite.setTexture(currentState.getCurrentSprite().getTexture());
			}else{
				System.out.println("Pleasse add an sprite renderer to this game object to use the animator");
			}
		}
	}
}
