
public class LineSegment2D {
	Interval intervalx, intervaly;
	LinearEquation2D line;
	
	public LineSegment2D(LinearEquation2D line, Interval intervalx, Interval intervaly){
		this.line =line;
		this.intervalx = intervalx;
		this.intervaly = intervaly;
	}
	public LineSegment2D(LinearEquation2D line){
		this.line = line;
		this.intervalx = new Interval(Double.MAX_VALUE, Double.MIN_VALUE);
		this.intervaly = new Interval(Double.MAX_VALUE, Double.MIN_VALUE);
	}
	public LineSegment2D(Vector2D a, Vector2D b){
		intervalx = new Interval(a.x,b.x);
		intervaly = new Interval(a.y,b.y);
		line = new LinearEquation2D(a,b);
	}
	public static Vector2D findLineSegInter(LineSegment2D a , LineSegment2D w) {
		if( a.intervalx.contains(LinearEquation2D.findLineInter(a.line, w.line).x)
		&& a.intervaly.contains(LinearEquation2D.findLineInter(a.line, w.line).y)
		&& w.intervalx.contains(LinearEquation2D.findLineInter(a.line, w.line).x)
		&& w.intervaly.contains(LinearEquation2D.findLineInter(a.line, w.line).y)){
			return LinearEquation2D.findLineInter(a.line, w.line);
		}else{
			return null;
		}
	}
}
