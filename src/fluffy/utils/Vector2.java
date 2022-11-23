package fluffy.utils;

public class Vector2 {
	
	public float x,y;
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}

	public Vector2(Vector2 val) {
		this.x = val.x;
		this.y = val.y;
	}

	public Vector2(float x) {
		this.x = x;
		this.y = 0;
	}

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void set(Vector2 val) {
		this.x = val.x;
		this.y = val.y;
	}

	public static Vector2 sum(Vector2 val1, Vector2 val2){
		float x = val1.x + val2.x;
		float y = val1.y + val2.y;
		return new Vector2(x,y);
	}

	public static Vector2 mul(Vector2 val1, Vector2 val2){
		float x = val1.x * val2.x;
		float y = val1.y * val2.y;
		return new Vector2(x,y);
	}
}
