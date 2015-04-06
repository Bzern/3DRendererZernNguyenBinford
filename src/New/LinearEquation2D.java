import java.awt.geom.Point2D;

public class LinearEquation2D {
	private static Vector2D slope, c, d;
	private static double b = 0;

	public LinearEquation2D(Vector2D point1, Vector2D point2) {
		this.c = slope;
		this.d = point2;
		this.slope = new Vector2D(point1);
		this.slope.subtract(point2);
		this.b = ((-1 * this.slope.getY() / this.slope.getX() * point2.getX()) + point2
				.getY());
	}

	public Vector2D evaluatex(double x) {
		if (slope.getX() == 0) {
			return null;
		} else {
			return new Vector2D(x, slope.getY() * x / slope.getX() + b);
		}
	}

	public Vector2D evaluatey(double y) {
		if (slope.getY() == 0) {
			return null;
		} else {
			return new Vector2D((y - b) / (slope.getY() / slope.getX()), y);
		}
	}

	public double findy(double x) {
		if (slope.getY() == 0) {
			return b;
		} else {
			return (slope.getY() * x / slope.getX() + b);
		}
	}

	public static Vector2D findLineInter(LinearEquation2D h, LinearEquation2D w) {
		if ((h.getSlope().getY() / h.getSlope().getX()) == (w.getSlope().getY() / w
				.getSlope().getX())) {
			return null;
		}
		if (h.getSlope().getX() == 0) {
			return w.evaluatex(h.getC().getX());
		}
		if (w.getSlope().getX() == 0) {
			// return h.evaluatex(w.c.x);
		}
		return new Vector2D((w.getB() - h.getB())
				/ ((h.getSlope().getY() / h.getSlope().getX()) - (w.getSlope()
						.getY() / w.getSlope().getX())), h.findy((w.getB() - h.getB())
				/ ((h.getSlope().getY() / h.getSlope().getX()) - (w.getSlope()
						.getY() / w.getSlope().getX()))));
	}
	
	public static Vector2D getSlope(){
		return slope;
	}
	
	public static Vector2D getC(){
		return c;
	}
	
	public static Vector2D getD(){
		return d;
	}
	
	public static double getB(){
		return b;
	}
	
	public static void setSlope(Vector2D vec){
		slope = vec;
	}
	
	public static void setC(Vector2D vec){
		c = vec;
	}
	
	public static void setD(Vector2D vec){
		d = vec;
	}
	
	public static void setB(double d){
		b = d;
	}
	
}
