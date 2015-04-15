import java.awt.Color;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	LinearEquation2D o = new LinearEquation2D(new Vector2D(1,1),new Vector2D(2,2));
	//	LinearEquation2D v = new LinearEquation2D(new Vector2D(4,1),new Vector2D(4,2));
		//LinearEquation2D.findLineInter(o,v).printVector();
	//	o.slope.printVector();
	//	System.out.println(o.b);
	//	System.out.println(v.b);
	//	v.slope.printVector();
		World3D world = new World3D();
		Point3D a = new Point3D(1, 1, 8);
		Point3D b = new Point3D(2, 1, 8);
		Point3D c = new Point3D(2, 2, 8);
		Point3D d = new Point3D(1, 2, 8);
		Point3D e = new Point3D(1, 1, 9);
		Point3D f = new Point3D(2, 1, 9);
		Point3D g = new Point3D(2, 2, 9);
		Point3D h = new Point3D(1, 2, 9);
		GameObject z = new GameObject(new Polygon3D[6]);
		Point3D[] q = new Point3D[4];
		q[0] = a;
		q[1] = b;
		q[2] = c;
		q[3] = d;
		z.faces[0] = new Polygon3D(q);
		z.faces[0].setBordercolor(Color.white);
		z.faces[0].setFillcolor(Color.red);
		Point3D[] j = new Point3D[4];
		j[0] = a;
     	j[1] = e;
		j[2] = h;
		j[3] = d;
		z.faces[2] = new Polygon3D(j);
		z.faces[2].setBordercolor(Color.white);
		z.faces[2].setFillcolor(Color.blue);
		Point3D[] w = new Point3D[4];
		w[0] = b;
		w[1] = f;
		w[2] = g;
		w[3] = c;
		z.faces[3] = new Polygon3D(w);
		z.faces[3].setBordercolor(Color.white);
		z.faces[3].setFillcolor(Color.green);
		Point3D[] t = new Point3D[4];
		t[0] = d;
		t[1] = c;
		t[2] = g;
		t[3] = h;
		z.faces[4] = new Polygon3D(t);
		z.faces[4].setBordercolor(Color.white);
		z.faces[4].setFillcolor(Color.orange);
		Point3D[] x = new Point3D[4];
		x[0] = a;
		x[1] = b;
		x[2] = f;
		x[3] = e;
		z.faces[5] = new Polygon3D(x);
		z.faces[5].setBordercolor(Color.white);
		z.faces[5].setFillcolor(Color.magenta);
		Point3D[] p = new Point3D[4];
		p[0] = e;
		p[1] = f;
		p[2] = g;
		p[3] = h;
		z.faces[1] = new Polygon3D(p);
		z.faces[1].setBordercolor(Color.white);
		z.faces[1].setFillcolor(Color.black);
		world.objects.add(z);
		world.camera.viewposition = new Point3D(0, 0, 0.9);
	}

}
