package fluffy.engine.library.collisions;

import fluffy.engine.library.Gameobject;
import fluffy.utils.Vector2;

import java.util.ArrayList;

public abstract class Collider {

    protected Gameobject parent;
    private ArrayList<Collider> collisions = new ArrayList<>();

    protected Vector2 position;

    public Collider()
    {}

    public void init(Gameobject parent){
        this.parent = parent;
        this.position = parent.transform.position;
    }

    public void init(Gameobject parent, Vector2 location){
        this.parent = parent;
        this.position = location;
    }

    public void clearCollisions(){
        collisions.clear();
    }

    public void addCollision(Collider other){
        collisions.add(other);
    }

    public abstract void visualize();

    public ArrayList<Collider> getCollisions(){
        return collisions;
    }

    public Gameobject getParent(){
        return parent;
    }
}

