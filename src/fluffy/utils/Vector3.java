package fluffy.utils;

public class Vector3 {
	
	public float x, y, z;	
	
	public Vector3(float x) {
		this.x = x;
		this.y = 0;
		this.z = 0;
	}

	
	public Vector3(float x, float y) {
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	
	public Vector3(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
