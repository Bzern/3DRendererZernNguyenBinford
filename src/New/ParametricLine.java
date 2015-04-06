public class ParametricLine
{
   private static Point2D origin, dir;
   private static double lbound, rbound;
   
   public ParametricLine(Point2D a, Point2D b)
   {
      double x = b.getX()-a.getX();
      double y = b.getY()-a.getY();
     
      origin = a;
      
      double mag = Math.sqrt(x*x + y*y);
      double xprime = x/mag;
      double yprime = y/mag;
      
      dir = new Point2D(xprime, yprime);
      lbound = 0;
      rbound = mag;
   }

   public static Point2D getOrigin()
   {
      return origin;
   }
   
   public static Point2D getDir()
   {
      return dir;
   }

   public static double getLbound()
   {
      return lbound;
   }
   
   public static double getRbound()
   {
      return rbound;
   }
   
   public static void setOrigin(Point2D x)
   {
      origin = x;
   }
  
   public static void setDir(Point2D x)
   {
      dir = x;
   }
   public static void setLbound(double x)
   {
      lbound = x;
   }
  
   public static void setRbound(double x)
   {
      rbound = x;
   }
   
   public Point2D intersection(ParametricLine other)
   {
      System.out.println("STARTED");
      double x1O = origin.getX();   System.out.println(x1O);
      double y1O = origin.getY();   System.out.println(y1O);
      double x1D = dir.getX();      System.out.println(x1D);
      double y1D = dir.getY();      System.out.println(y1D);
      
      double x2O = other.getOrigin().getX(); System.out.println(x2O);
      double y2O = other.getOrigin().getY(); System.out.println(y2O);
      double x2D = other.getDir().getX();    System.out.println(x2D);
      double y2D = other.getDir().getY();    System.out.println(y2D);
      
      double time1 = (x2O*y2D - x2D*y2O + x2D*y1O - x1O*y2D)
                /(x1D*y2D - x2D*y1D);
                
      if(time1<lbound || time1>rbound)
      {
         System.out.println("TRIGGER 1");
         return null;
      }
      
      Point2D fin = new Point2D( (x1O + x1D*time1), (y1O+ y1D*time1) );
      
      double time2 = (Point2D.getX()-x2O)/x2D;
      if(time2<other.getLbound() || time2>other.getRbound())
      {
         System.out.println("TRIGGER 2");
         return null;
      }
      System.out.println(time1 + " " + time2 + " " + fin.getX() + " " + fin.getY());
      
      return fin;
   }


   public static void main(String[] args)
   {
      Point2D start1 = new Point2D(1.0, 1.0);
      Point2D dir1 = new Point2D(3.0, 3.0);
      
      Point2D start2 = new Point2D(1.0, 3.0);
      Point2D dir2 = new Point2D(5.0, 5.0);
      
      ParametricLine one = new ParametricLine(start1, dir1);
      System.out.println(one.getOrigin().getX());
      
      ParametricLine two = new ParametricLine(start2, dir2);
   
      Point2D intersect = one.intersection(two);
      System.out.println(intersect.getX());
      System.out.println(intersect.getY());
   }
}