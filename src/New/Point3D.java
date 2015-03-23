import java.awt.geom.Point2D;

public class Point3D {
	private static double x, y, z;

	public Point3D(double x, double y, double z) {
		x = x;
		y = y;
		z = z;

	}

	public Point3D(Point3D p) {
		x = p.getX();
		y = p.getY();
		z = p.getZ();
	}

	public void subtract(Point3D b) {
		x = x - b.getX();
		y = y - b.getY();
		z = z - b.getZ();
	}

	public void add(Point3D b) {
		x = x + b.getX();
		y = y + b.getY();
		z = z + b.getZ();
	}

	public double distance(Point3D a) {
		Double distance = 0.0;
		distance = Math.sqrt(Math.pow(x - a.getX(), 2) + Math.pow(y - a.getY(), 2)
				+ Math.pow(z - a.getY(), 2));
		return distance;
	}

	public Point3D rotate(Point3D origin, Point3D orientation) {
		Point3D p = new Point3D(this);
		p.setX(p.getX() - origin.getX());
		p.setY(p.getY() - origin.getY());
		p.setZ(p.getZ() - origin.getZ());
		p = p.rotate(orientation);
		p.setX(p.getX() + origin.getX());
		p.setY(p.getY() + origin.getY());
		p.setZ(p.getZ() + origin.getZ());
		return p;

	}

	public Point3D rotate(Point3D orientation) {
		Point3D d = new Point3D(this);
		d.setX(Math.cos(orientation.getY())
				* (-Math.sin(orientation.getZ()) * (d.getY()) + Math.cos(orientation.getZ())
						* (d.getX())) - -Math.sin(orientation.getY()) * (d.getZ()));
		d.setY(-Math.sin(orientation.getX())
				* (Math.cos(orientation.getY()) * (d.getZ()) + -Math.sin(orientation.getY())
						* (-Math.sin(orientation.getZ()) * (d.getY()) + Math
								.cos(orientation.getZ()) * (d.getX())))
				+ Math.cos(orientation.getX())
				* (Math.cos(orientation.getZ()) * (d.getY()) - -Math.sin(orientation.getZ())
						* (d.getX())));
		d.setZ(Math.cos(orientation.getX())
				* (Math.cos(orientation.getY()) * (d.getZ()) + -Math.sin(orientation.getY())
						* (-Math.sin(orientation.getZ()) * (d.getY()) + Math
								.cos(orientation.getZ()) * (d.getX())))
				- -Math.sin(orientation.getX())
				* (Math.cos(orientation.getZ()) * (d.getY()) - -Math.sin(orientation.getZ())
						* (d.getX())));
		return d;

	}

	public Point3D scale(double i) {
		Point3D p = new Point3D(this);
		p.setX(getX() * i);
		p.setY(getY() * i);
		p.setZ(getZ() * i);
		return p;

	}
  
   public static double getX() {
      return x;
   }
   
   public static double getY() {
      return y;
   }
   
   public static double getZ() {
      return z;
   } 
   
   public static void setX(double nx) {
      x = nx;
   }
   
   public static void setY(double ny) {
      y = ny;
   }
   
   public static void setZ(double nz) {
      z = nz;
   }  
  
   public String toString() {
		String str = ("(" + x + "," + y + "," + z + ")");
      return str;
	}

}
