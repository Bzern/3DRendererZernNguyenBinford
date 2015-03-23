public class Vector2D {
	double x = 0;
	double y = 0;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D(Vector2D b) {
		this.x = b.x;
		this.y = b.y;
	}

	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	public void multScalar(double s) {
		this.x *= s;
		this.y *= s;
	}

	public void add(Vector2D c) {
		this.x += c.x;
		this.y += c.y;
	}

	public void subtract(Vector2D c) {
		this.x -= c.x;
		this.y -= c.y;

	}

	public void printVector() {
		System.out.println("(" + x + "," + y + ")");
	}

}
