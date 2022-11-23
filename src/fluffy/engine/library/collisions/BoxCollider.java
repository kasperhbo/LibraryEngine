package fluffy.engine.library.collisions;

import fluffy.engine.library.Gameobject;
import fluffy.engine.library.Window;
import fluffy.utils.Vector2;

public class BoxCollider extends Collider{

    Vector2 size;

    public BoxCollider()
    {
        super();
    }

    @Override
    public void init(Gameobject parent) {
        this.size = parent.transform.size;
        Vector2 pos = parent.transform.position;
        super.init(parent, pos);
    }

    public void init(Gameobject parent, Vector2 offset, Vector2 scaleMultiplier) {
        this.size = Vector2.mul(parent.transform.size, scaleMultiplier);
        Vector2 pos = Vector2.sum(parent.transform.position, offset);
        super.init(parent, pos);
    }

    @Override
    public void visualize(){
        Window.getParent().rect(position.x, position.y, size.x, size.y);
    }
}

