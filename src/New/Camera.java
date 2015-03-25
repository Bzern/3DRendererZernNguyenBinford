import java.awt.geom.Point2D;

public class Camera {
	Point3D position = new Point3D(0, 0, 0);
	Point3D orientation = new Point3D(0, 0, 0);
	Point3D viewposition = new Point3D(0, 0, 0);

	public Point2D.Double turn2Dto3D(Point3D b) {
		Point2D.Double returnpoint = new Point2D.Double();
		Point3D d = new Point3D(b);
		d.setX(d.getX() - position.getX());
		d.setY(d.getY() - position.getY());
		d.setZ(d.getZ() - position.getZ());
		d = d.rotate(orientation.scale(-1));
		returnpoint.setX((d.getX() - viewposition.getX()) * (viewposition.getZ() / d.getZ()));
		returnpoint.setY((d.getY() - viewposition.getY()) * (-viewposition.getZ() / d.getZ()));
		if (d.getZ() > viewposition.getZ()) {
			return returnpoint;
		} else {
			return null;
		}
	}

	public void print2DPoint(Point2D.Double b) {
		System.out.println("(" + b.getX() + "," + b.getY() + ")");
	}

	public int turndoubletoroundedint(double aa) {
		return (int) Math.round(aa);
	}

}
