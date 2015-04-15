import java.util.*;

final class IntersectValue
{
   private final Point2D intersect;
   private final int doesIntersect;
   private final ParametricLine lineIntersect;
   
   public IntersectValue(int value)
   {
      this.intersect = null;
      this.doesIntersect = value;
      this.lineIntersect = null;
   }

   
   public IntersectValue(int value, Point2D point)
   {
      this.intersect = point;
      this.doesIntersect = value;
      this.lineIntersect = null;
   }
   
   public IntersectValue(int value, ParametricLine intersect)
   {
      this.intersect = null;
      this.doesIntersect = value;
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
}

public class ParametricLine
{
   private Point2D origin, dir;
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
   }

   public Point2D getOrigin()
   {
      return origin;
   }
   
   public Point2D getDir()
   {
      return dir;
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
   public void setLbound(double x)
   {
      lbound = x;
   }
  
   public void setRbound(double x)
   {
      rbound = x;
   }
   
   public IntersectValue hasIntersect(ParametricLine other)
   {
      //Initialize
      double x1O = origin.getX();   //System.out.println(x1O);
      double y1O = origin.getY();   //System.out.println(y1O);
      double x1D = dir.getX();     // System.out.println(x1D);
      double y1D = dir.getY();     // System.out.println(y1D);
      
      double x2O = other.getOrigin().getX(); //System.out.println(x2O);
      double y2O = other.getOrigin().getY(); //System.out.println(y2O);
      double x2D = other.getDir().getX();   // System.out.println(x2D);
      double y2D = other.getDir().getY();   // System.out.println(y2D);
      
      double time1 = (x2O*y2D - x2D*y2O + x2D*y1O - x1O*y2D)
                /(x1D*y2D - x2D*y1D);
                
      //Endpoint Test  Is equals needed to be added to Point2D
      
      
      //Collinear Test
      if((y1D-y1O)/(x1D-x1O)== (y2O-y1O)/(x2O-x1O))//DOES NOT WORK
      {
         Point2D[] points = {origin, new Point2D(dir.getX()*rbound, dir.getY()*rbound), other.origin, new Point2D(other.getDir().getX()*other.getRbound(), other.getDir().getX()*other.getRbound())};
         ArrayList<Integer> middle = new ArrayList<>();
         for(int i = 0; i<3; i++)
         {
            int count=0;
            for(int j = 0; j<3; j++)
            {
               if(i!=j && points[i].getX()>points[j].getX())
               count++;
            }
            if(count == 2||count==3)
               middle.add(i);
         }
         return new IntersectValue(2, new ParametricLine(points[middle.get(0)], points[middle.get(1)]));
      }
      
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
   
   /*public Point2D intersection(ParametricLine other)
   {
      //System.out.println("STARTED");
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
                System.out.println("Time: "+time1);
                
     
     
      if(time1<lbound || time1>rbound)
      {
         System.out.println("TRIGGER 1");
         return null;
      }
      
      Point2D fin = new Point2D( (x1O + x1D*time1), (y1O+ y1D*time1) );
      
      double time2 = (fin.getX()-x2O)/x2D;
      if(time2<other.getLbound() || time2>other.getRbound())
      {
         System.out.println("TRIGGER 2");
         return null;
      }
     // System.out.println(time1 + " " + time2 + " " + fin.getX() + " " + fin.getY());
      
      //If Dir1 == Dir2, collinear?
           
      return fin;
   }*/


   public static void main(String[] args)
   {
      //Set up points
      Point2D start1 = new Point2D(1.0, 1.0);  // System.out.println(start1.getX());
      Point2D dir1 = new Point2D(5.0, 1.0);
      
      Point2D start2 = new Point2D(3.0, 1.0);
      Point2D dir2 = new Point2D(4.0, 1.0);
      
      //Set up parametric lines
      ParametricLine one = new ParametricLine(start1, dir1);
      ParametricLine two = new ParametricLine(start2, dir2);
     
      //Find intersections
      IntersectValue last = one.hasIntersect(two);
      System.out.println(last.getDoesIntersect());
      
    }
}