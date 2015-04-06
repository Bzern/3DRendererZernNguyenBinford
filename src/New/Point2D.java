
public class Point2D {
   private double x, y;

	public Point2D(double x1, double y1) {
		x = x1;
		y = y1;
	}
   
   public Point2D() {
		x = 0.0;
		y = 0.0;
	}

	public Point2D(Point2D p) {
		x = p.getX();
		y = p.getY();
	}

	public void subtract(Point2D b) {
		x = x - b.getX();
		y = y - b.getY();
	}

	public void add(Point2D b) {
		x = x + b.getX();
		y = y + b.getY();
	}
   public double getX() {
      return x;
   }
   
   public double getY() {
      return y;
   }
   
   public void setX(double nx) {
      x = nx;
   }
   
   public void setY(double ny) {
      y = ny;
   }
  
   public String toString() {
		String str = ("(" + x + "," + y +")");
      return str;
	}

}