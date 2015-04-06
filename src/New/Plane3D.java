public class Plane3D {
   private double a,b,c,k;
   
   public Plane3D(Point3D p1, Point3D p2, Point3D p3){
      System.out.println(p1);
      System.out.println(p2);
      System.out.println(p3);
      Point3D vec1 = p1.subtractRetP(p2);
      System.out.println(vec1);
      Point3D vec2 = p1.subtractRetP(p3);
       System.out.println(vec2);
      Point3D prod = crossprod(vec1,vec2);
      a = prod.getX();
      b = prod.getY();
      c = prod.getZ();
      k = (-1*p2.getX())+(-1*p2.getY())+(-1*p2.getZ());
   }
   public Point3D crossprod(Point3D a,Point3D b){
      Point3D cross = new Point3D(a.getY()*b.getZ()-a.getZ()*b.getY(),a.getZ()*b.getX()-a.getX()*b.getZ(),
      a.getX()*b.getY()-a.getY()*b.getX());
      return cross;
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
   
   public static void main(String[] args){
      Point3D p1 = new Point3D(1,3,9);
      System.out.println(p1.getX());
      Point3D p2 = new Point3D(5,8,4);
      Point3D p3 = new Point3D(9,7,2);
      System.out.println(p1+"\n"+p2+"\n"+p3);
      Plane3D bob = new Plane3D(p1, p2, p3);
      //System.out.println(bob.getA() +" "bob.getB()+" "+bob.getC()+bob.getZ(new Point2D(3,6)));
   
   }
}