public class GameObject {
	Polygon3D[] faces;

	public GameObject(Polygon3D[] a) {
		faces = a;
	}

	public void act() {
		for (Polygon3D p : faces) {
			for (Point3D a : p.polygon3Dpoints) {
				Point3D c = a.rotate(faces[5].center(), new Point3D(
						0, 0.01, 0.01));
				a.x = c.x;
				a.y = c.y;
				a.z = c.z;
			}
		}
	}

}
