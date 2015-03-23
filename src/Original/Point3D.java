import java.awt.geom.Point2D;

public class Point3D {
	double x, y, z;

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;

	}

	public Point3D(Point3D p) {
		x = p.x;
		y = p.y;
		z = p.z;
	}

	public void subtract(Point3D b) {
		x = x - b.x;
		y = y - b.y;
		z = z - b.z;
	}

	public void add(Point3D b) {
		x = x + b.x;
		y = y + b.y;
		z = z + b.z;
	}

	public double distance(Point3D a) {
		Double distance = 0.0;
		distance = Math.sqrt(Math.pow(x - a.x, 2) + Math.pow(y - a.y, 2)
				+ Math.pow(z - a.z, 2));
		return distance;
	}

	public Point3D rotate(Point3D origin, Point3D orientation) {
		Point3D p = new Point3D(this);
		p.x -= origin.x;
		p.y -= origin.y;
		p.z -= origin.z;
		p = p.rotate(orientation);
		p.x += origin.x;
		p.y += origin.y;
		p.z += origin.z;
		return p;

	}

	public Point3D rotate(Point3D orientation) {
		Point3D d = new Point3D(this);
		d.x = Math.cos(orientation.y)
				* (-Math.sin(orientation.z) * (d.y) + Math.cos(orientation.z)
						* (d.x)) - -Math.sin(orientation.y) * (d.z);
		d.y = -Math.sin(orientation.x)
				* (Math.cos(orientation.y) * (d.z) + -Math.sin(orientation.y)
						* (-Math.sin(orientation.z) * (d.y) + Math
								.cos(orientation.z) * (d.x)))
				+ Math.cos(orientation.x)
				* (Math.cos(orientation.z) * (d.y) - -Math.sin(orientation.z)
						* (d.x));
		d.z = Math.cos(orientation.x)
				* (Math.cos(orientation.y) * (d.z) + -Math.sin(orientation.y)
						* (-Math.sin(orientation.z) * (d.y) + Math
								.cos(orientation.z) * (d.x)))
				- -Math.sin(orientation.x)
				* (Math.cos(orientation.z) * (d.y) - -Math.sin(orientation.z)
						* (d.x));
		return d;

	}

	public Point3D scale(double i) {
		Point3D p = new Point3D(this);
		p.x *= i;
		p.y *= i;
		p.z *= i;
		return p;

	}

	public void printPoint() {
		System.out.println("(" + x + "," + y + "," + z + ")");
	}

}
