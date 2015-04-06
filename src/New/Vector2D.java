public class Vector2D {
	private static double x = 0;
	private static double y = 0;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D(Vector2D b) {
		this.x = b.getX();
		this.y = b.getY();
	}

	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	public void multScalar(double s) {
		this.x *= s;
		this.y *= s;
	}

	public void add(Vector2D c) {
		this.x += c.getX();
		this.y += c.getY();
	}

	public void subtract(Vector2D c) {
		this.x -= c.getX();
		this.y -= c.getY();

	}

	public void printVector() {
		System.out.println("(" + x + "," + y + ")");
	}
   
   public String toString()
   {
      String ret = ("(" + x + "," + y + ")");
      return ret;
   }
   
   public double getX() {
      return x;
   }
   
   public double getY() {
      return x;
   }
   
   public void setX(double xx) {
      x = xx;
   }
   
   public void setY(double yy) {
      y = yy;
   }

}
