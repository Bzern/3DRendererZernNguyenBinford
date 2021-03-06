
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
   
   public boolean equals(Point2D p) {
      if (x == p.getX() && y == p.getY())
         return true;
      return false;
   }
   
   public Point2D multiply(double factor)
   {
      Point2D ret = new Point2D();
      ret.setX(x*factor);
      ret.setY(y*factor);
      return ret;
   }
   
   public Point2D multiply(double xfactor, double yfactor)
   {
      Point2D ret = new Point2D();
      ret.setX(x*xfactor);
      ret.setY(y*yfactor);
      return ret;
   }
}