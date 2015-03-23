import java.awt.geom.Point2D;

public class Camera {
	Point3D position = new Point3D(0, 0, 0);
	Point3D orientation = new Point3D(0, 0, 0);
	Point3D viewposition = new Point3D(0, 0, 0);

	public Point2D.Double turn2Dto3D(Point3D b) {
		Point2D.Double returnpoint = new Point2D.Double();
		Point3D d = new Point3D(b);
		d.x -= position.x;
		d.y -= position.y;
		d.z -= position.z;
		d = d.rotate(orientation.scale(-1));
		returnpoint.x = (d.x - viewposition.x) * (viewposition.z / d.z);
		returnpoint.y = (d.y - viewposition.y) * (-viewposition.z / d.z);
		if (d.z > viewposition.z) {
			return returnpoint;
		} else {
			return null;
		}
	}

	public void print2DPoint(Point2D.Double b) {
		System.out.println("(" + b.x + "," + b.y + ")");
	}

	public int turndoubletoroundedint(double aa) {
		return (int) Math.round(aa);
	}

}
