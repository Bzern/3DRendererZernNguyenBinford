import java.awt.Color;


public class Polygon3D implements Comparable<Polygon3D>{
	private Point3D[] polygon3Dpoints;
	private Color bordercolor;
	private Color fillcolor;
	private Double distancetocenter = 0.0;
	
   public Polygon3D(Point3D[] a){
		polygon3Dpoints = a;
	}
	public Point3D center(){
		Point3D center=new Point3D(0,0,0);
		Point3D sum = new Point3D(0,0,0);
         for(int i=0; i < polygon3Dpoints.length ; i++){   
        	 sum.setX(sum.getX() + polygon3Dpoints[i].getX());
	}
         center.setX(sum.getX() / polygon3Dpoints.length);
         for(int i=0; i < polygon3Dpoints.length ; i++){   
        	 sum.setY(sum.getY() + polygon3Dpoints[i].getY());
	}
         center.setY(sum.getY() / polygon3Dpoints.length);
         for(int i=0; i < polygon3Dpoints.length ; i++){   
        	 sum.setZ(sum.getZ() + polygon3Dpoints[i].getZ());
	}
         center.setZ(sum.getZ() / polygon3Dpoints.length);
         return center;
	}
	@Override
	public int compareTo(Polygon3D otherPolygon) {
		
		return -1*Double.compare(this.distancetocenter, otherPolygon.getDistancetocenter());
	}
   
   public Point3D[] getPolygon3Dpoints(){
      return polygon3Dpoints;
   }
   public Color getBordercolor(){
      return bordercolor;
   }
   public Color getFillcolor(){
      return fillcolor;
   }
   public Double getDistancetocenter(){
      return distancetocenter;
   }
   
   public void setBordercolor(Color col){
      bordercolor = col;
   }
   public void setFillcolor(Color col){
      fillcolor = col;
   }
   public void setPolygon3Dpoints(Point3D[] points){
      polygon3Dpoints = points;
   }
   
   public void setDistancetocenter(Double dist){
      distancetocenter = dist;
   }
   
   public Point2D yInterval()
   {
      double low = polygon3Dpoints[0].getY();
      double high = polygon3Dpoints[0].getY();
      for(int i = 1; i< polygon3Dpoints.length; i++)
      {
         if(polygon3Dpoints[i].getY()<low)
            low = polygon3Dpoints[i].getY();
         if(polygon3Dpoints[i].getY()>high)
            high = polygon3Dpoints[i].getX();
      }
      return new Point2D(low, high);
   }
}
