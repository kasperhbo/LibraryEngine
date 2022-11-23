package fluffy.engine.library.rendering;

import fluffy.utils.Transform;
import fluffy.utils.Vector2;

public class Camera {

    public Transform transform;
    
    public Camera()
    {
    	transform = new Transform(new Vector2(), new Vector2());
    }

    public Camera(Vector2 position)
    {
        transform.position = position;
        transform.size = new Vector2();
    }
	
}
