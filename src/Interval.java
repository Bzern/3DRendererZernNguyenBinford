public class Interval {
	public double min, max;

	public boolean contains(double x) {
		return (x >= min && x <= max);
	}
	public Interval(Double a, Double b){
		this.max=Math.max(a,b);
		this.min=Math.min(a,b);
	}

	public Interval intersection(Interval a) {
		Interval v = new Interval(0.0,0.0);
		v.min = Math.max(a.min, min);
		v.max = Math.min(a.max, max);
		return v;
	}
}
