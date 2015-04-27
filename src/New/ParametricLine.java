import java.util.*;

final class IntersectValue
{
   private final Point2D intersect;
   private final int doesIntersect;
   private final ParametricLine lineIntersect;
   
   public IntersectValue(int value)
   {
      this.intersect = null;
      this.doesIntersect = value;//Should be 0
      this.lineIntersect = null;
   }

   
   public IntersectValue(int value, Point2D point)
   {
      this.intersect = point;
      this.doesIntersect = value;//Should be 1
      this.lineIntersect = null;
   }
   
   public IntersectValue(int value, ParametricLine intersect)
   {
      this.intersect = null;
      this.doesIntersect = value;//should be 2
      this.lineIntersect = intersect;
   }
   
   public int getDoesIntersect()
   {
      return doesIntersect;
   }
   
   public Point2D getIntersect()
   {
      return intersect;
   }
   
   public ParametricLine getLineIntersect()
   {
      return lineIntersect;
   }
   
   public String toString()
   {
      return (doesIntersect+"\n"+intersect+"\n"+lineIntersect);
   }
}

public class ParametricLine
{
   private Point2D origin, end, dir;
   private double lbound, rbound;
   
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
      end = b;
   }

   public Point2D getOrigin()
   {
      return origin;
   }
   
   public Point2D getDir()
   {
      return dir;
   }
   
   public Point2D getEnd()
   {
      return end;
   }

   public double getLbound()
   {
      return lbound;
   }
   
   public double getRbound()
   {
      return rbound;
   }
   
   public void setOrigin(Point2D x)
   {
      origin = x;
   }
  
   public void setDir(Point2D x)
   {
      dir = x;
   }
  
   public void setEnd(Point2D x)
   {
      end = x;
   }
  
   public void setLbound(double x)
   {
      lbound = x;
   }
  
   public void setRbound(double x)
   {
      rbound = x;
   }
   
   public String toString()
   {
      return ("Origin: "+origin+"  Dir: "+dir+"  End: "+end+"  Left Bound: "+lbound+"  Right Bound: "+rbound);
   }
   
   public boolean isCollinear(ParametricLine other)
   {
      Point2D origin2 = other.getOrigin();
      Point2D dir2 = other.getDir();
      if(!dir.equals(dir2) && !dir.equals(dir2.multiply(-1)))
      {  
         //System.out.println("NO DIR");
         return false;
      }
      if(origin.equals(origin2))
         return true;
      double slope1 = (origin.getY()-origin2.getY())/(origin.getX()-origin2.getX());
      double slope2 = (dir.getY())/(dir.getX());
      if(slope1==slope2||slope1==-1*slope2)
         return true;
      //System.out.println((origin.getY()-origin2.getY())/(origin.getX()-origin2.getX())+"WTF"+(dir.getY())/(dir.getX()));
      return false;
   }
   
   public IntersectValue hasIntersect(ParametricLine other) //PROBLEMS: ARE COLLINEAR OR ENDPOINTS REQUIRED FOR REAL WORLD PROBLEMS? DO THEY TAKE UP TOO MUCH MEMORY?
   {
      //Initialize
      double x1O = origin.getX();            //System.out.println("x1O " + x1O);
      double y1O = origin.getY();            //System.out.println("y1O " + y1O);
      double x1D = dir.getX();               //System.out.println("x1D " + x1D);
      double y1D = dir.getY();               //System.out.println("y1D " + y1D);
      double x1E = end.getX();               //System.out.println("x1E " + x1E);
      double y1E = end.getY();               //System.out.println("y1E " + y1E);
      
      double x2O = other.getOrigin().getX(); //System.out.println("x2O " + x2O);
      double y2O = other.getOrigin().getY(); //System.out.println("y2O " + y2O);
      double x2D = other.getDir().getX();    //System.out.println("x2D " + x2D);
      double y2D = other.getDir().getY();    //System.out.println("y2D " + y2D);
      double x2E = end.getX();               //System.out.println("x2E " + x2E);
      double y2E = end.getY();               //System.out.println("y2E " + y2E);
      
      double time1 = (x2O*y2D - x2D*y2O + x2D*y1O - x1O*y2D)
                /(x1D*y2D - x2D*y1D);
      
      //Endpoint Test part 1
      int same = 0;
      if(origin.equals(other.getOrigin())
       ||origin.equals(other.getEnd()) )
               {
         same = same +1;
      }
      if(end.equals(other.getOrigin())
       ||end.equals(other.getEnd()) )
      {
         same = same + 2;
      }
      if(same==3)
         return new IntersectValue(2, new ParametricLine(origin, end));
               
      //Collinear Test
      if(isCollinear(other))
      {
         System.out.println("COLLINEAR");
         Point2D[] points = {origin, getEnd(), other.getOrigin(),
                             other.getEnd()};
         ArrayList<Integer> middle = new ArrayList<>();
         int[] counts= new int[4];
         for(int i = 0; i<4; i++)
         {
            int count=0;
            for(int j = 0; j<4; j++)
            {
               if(i!=j && points[i].getX()>points[j].getX())
                  count++;
               else if(i!=j&&points[i].getX()==points[j].getX()&&points[i].getY()>=points[j].getY())
                  count++;
            }
            //System.out.println(i+ " "+count);
            counts[i]=count;
            if(count == 1||count==2)
               middle.add(i);
         }
         System.out.println("0: "+counts[0]+"\n1: "+counts[1]+"\n2: "+counts[2]+"\n3: "+counts[3]);
         if(counts[0]+counts[1]>=5||counts[2]+counts[3]>=5);
         else return new IntersectValue(2, new ParametricLine(points[middle.get(0)], points[middle.get(1)]));
      }
      
      //Endpoint Test
     
      if(same==1)
         return new IntersectValue(1, origin);
      if(same==2)
         return new IntersectValue(1, end);
      
      //Single Intersection Test
      if(x1D*y2D - x2D*y1D != 0)
      { 
         
         Point2D fin = new Point2D( (x1O + x1D*time1), (y1O+ y1D*time1) );
         double time2 = (fin.getX()-x2O)/x2D;
         if(! (time1<lbound || time1>rbound) && !(time2<other.getLbound() || time2>other.getRbound()))
         {
            return new IntersectValue(1, fin);
         }
      }
      
      //No Intersection
      return new IntersectValue(0);  
   }  
   
   public static void test(double one, double two, double three, double four, double five, double six, double seven, double eight)
   {
      //Set up Points
      Point2D start1 = new Point2D(one, two);
      Point2D dir1 = new Point2D(three, four);
      
      Point2D start2 = new Point2D(five, six);
      Point2D dir2 = new Point2D(seven, eight);
      
      ParametricLine A = new ParametricLine(start1, dir1);
      ParametricLine B = new ParametricLine(start2, dir2);
     
      //Find intersections
      IntersectValue last = A.hasIntersect(B);
      System.out.println(last);
   }
   
   public static void main(String[] args)
   {
      test(-1.0, -1.0,  //Line 1 point 1
            1.0, 1.0,   //Line 1 point 2
            
            0.0, 0.0,   //Line 2 point 1
            2.0, 2.0);  //Line 2 point 2
   }
}