
public class Point2D {
   private static double x, y;

	public Point2D(double x, double y) {
		x = x;
		y = y;
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
   public static double getX() {
      return x;
   }
   
   public static double getY() {
      return y;
   }
   
   public static void setX(double nx) {
      x = nx;
   }
   
   public static void setY(double ny) {
      y = ny;
   }
  
   public String toString() {
		String str = ("(" + x + "," + y +")");
      return str;
	}

}