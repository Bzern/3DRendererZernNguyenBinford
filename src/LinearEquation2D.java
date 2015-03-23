import java.awt.geom.Point2D;

public class LinearEquation2D {
	Vector2D slope,c,d;
	double b=0;

	public LinearEquation2D(Vector2D point1, Vector2D point2) {
		this.c=slope;
		this.d=point2;
		this.slope = new Vector2D(point1);
		this.slope.subtract(point2);
		this.b = ((-1*this.slope.y/this.slope.x*point2.x)+point2.y);
	}

	public Vector2D evaluatex(double x) {
		if(slope.x==0){
			return null;
		}else{
			return new Vector2D(x,slope.y*x/slope.x+b);
		}
	}
	public Vector2D evaluatey(double y) {
		if(slope.y==0){
			return null;
		}else{
			return new Vector2D((y-b)/(slope.y/slope.x),y);
		}
	}
	public double findy(double x) {
		if(slope.y==0){
			return b;
		}else{
			return (slope.y*x/slope.x+b);
		}
	}

	public static Vector2D findLineInter(LinearEquation2D h, LinearEquation2D w) {
		if((h.slope.y/h.slope.x)==(w.slope.y/w.slope.x)){
			return null;
		}
		if(h.slope.x==0){
		return w.evaluatex(h.c.x);
		}
		if(w.slope.x==0){
		//return h.evaluatex(w.c.x);
		}
		return new Vector2D((w.b-h.b)/((h.slope.y/h.slope.x)-(w.slope.y/w.slope.x)),h.findy((w.b-h.b)/((h.slope.y/h.slope.x)-(w.slope.y/w.slope.x))));
	}
}
