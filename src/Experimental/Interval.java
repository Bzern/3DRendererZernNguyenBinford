public class Interval {
	private double min, max;

	public boolean contains(double x) {
		return (x >= min && x <= max);
	}
	public Interval(Double a, Double b){
		this.max=Math.max(a,b);
		this.min=Math.min(a,b);
	}

	public Interval intersection(Interval a) {
		Interval v = new Interval(0.0,0.0);
		v.setMin(Math.max(a.getMin(), min));
		v.setMax(Math.min(a.getMax(), max));
		return v;
	}
   
   public static double getMin() {
      return min;
   }
   
   public static double getMax() {
      return max;
   }
   
   public static void setMin(double nmin) {
      min = nmin;
   }
   
   public static void setMax(double nmax) {
      max = nmax;
   }
}
