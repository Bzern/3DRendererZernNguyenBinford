public class Camera {
	Point3D position = new Point3D(0, 0, 0);
	Point3D orientation = new Point3D(0, 0, 0);
	Point3D viewposition = new Point3D(0, 0, 0);

	public Point2D turn2Dto3D(Point3D b) {
		Point2D returnpoint = new Point2D();
		Point3D d = new Point3D(b);
		d.setX(d.getX() - position.getX());
		d.setY(d.getY() - position.getY());
		d.setZ(d.getZ() - position.getZ());
		d = d.rotate(orientation.scale(-1));
		returnpoint.setX((d.getX() * (viewposition.getZ() / d.getZ())) - viewposition.getX());
		returnpoint.setY((d.getY() * (viewposition.getZ() / d.getZ())) - viewposition.getY());
		if (d.getZ() > viewposition.getZ()) {
			return returnpoint;
		} else {
			return null;
		}
	}

	public void print2DPoint(Point2D b) {
		System.out.println("(" + b.getX() + "," + b.getY() + ")");
	}

	public int turndoubletoroundedint(double aa) {
		return (int) Math.round(aa);
	}

}
