package fluffy.utils;

public class Transform {
	
	public Vector2 position;
	public Vector2 size;
	
	public Transform(Vector2 position, Vector2 size) {
		this.position = position;
		this.size = size;
	}

    public Transform copy() {
		return new Transform(new Vector2(this.position), new Vector2(this.size));
    }

	public void copy(Transform to) {
		to.position.set(this.position);
		to.size.set(this.size);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Transform)) return false;

		Transform t = (Transform)o;
		
		return t.position.equals(this.position) && t.size.equals(this.size);
	}
}
