public class Plane3D {
   private static double a,b,c,k;
   
   public Plane3D(Point3D p1, Point3D p2, Point3D p3){
      Point3D vec1 = p1.subtractRetP(p2);
      Point3D vec2 = p1.subtractRetP(p3);
      Point3D prod = crossprod(vec1,vec2);
      a = prod.getX();
      b = prod.getY();
      c = prod.getZ();
      k = (-1*p2.getX())+(-1*p2.getY())+(-1*p2.getZ());
   }
   public double getA(){
      return a;
   }
    public double getB(){
      return b;
   }
    public double getC(){
      return c;
   }
    public double getK(){
      return k;
   }
   public double getZ(Point2D bob){
      return (bob.getX()*a*-1 + bob.getY()*b*-1-k)/c;
   }
}