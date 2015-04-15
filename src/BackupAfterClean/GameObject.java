public class GameObject {
	Polygon3D[] faces;

	public GameObject(Polygon3D[] a) {
		faces = a;
	}

	public void act() {
		for (Polygon3D p : faces) {
			for (Point3D a : p.getPolygon3Dpoints()) {
				Point3D c = a.rotate(faces[5].center(), new Point3D(
						0.0, 0.0, 0.01));
				a.setX(c.getX());
				a.setY(c.getY());
				a.setZ(c.getZ());
			}
		}
	}

}
