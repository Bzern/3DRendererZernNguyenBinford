public class Interval {
	private double xLow, xHigh, y;
   private Color color;
   
   public Interval {
      xLow = 0;
      xHigh = 0;
      y = 0;
      color = color.White;
   }
   
   public Interval(low, high) {
      xLow = low;
      xHigh = high;
      y = 0;
      color = color.White;
   }

   public Interval(low, high, Color col) {
      xLow = low;
      xHigh = high;
      y = 0;
      color = col;
   }

   public Interval(low, high, yval) {
      xLow = low;
      xHigh = high;
      y = yval;
      color = Color.White;
   }
   
   public Interval(low, high, yval, Color col) {
      xLow = low;
      xHigh = high;
      y = yval;
      color = col;
   }
   
   public double getXLow() {
      return xLow;
   }
   
   public double getXHigh() {
      return xHigh;
   }
   
   public double getY() {
      return y;
   }
   
   public Color getColor() {
      return color;
   }
   
   public double setXLow(double low) {
      xLow = low;
   }
   
   public double setXHigh(double high) {
      xHigh = high;
   }
   
   public double setY(double yval) {
      y = yval;
   }
   
   public Color setColor(Color col) {
      color = col;
   }
}
