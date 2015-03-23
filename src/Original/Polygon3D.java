import java.awt.Color;


public class Polygon3D implements Comparable<Polygon3D>{
	Point3D[] polygon3Dpoints;
	Color bordercolor;
	Color fillcolor;
	Double distancetocenter = 0.0;
	public Polygon3D(Point3D[] a){
		polygon3Dpoints = a;
	}
	public Point3D center(){
		Point3D center=new Point3D(0,0,0);
		Point3D sum = new Point3D(0,0,0);
         for(int i=0; i < polygon3Dpoints.length ; i++){   
        	 sum.x = sum.x + polygon3Dpoints[i].x;
	}
         center.x = sum.x / polygon3Dpoints.length;
         for(int i=0; i < polygon3Dpoints.length ; i++){   
        	 sum.y = sum.y + polygon3Dpoints[i].y;
	}
         center.y = sum.y / polygon3Dpoints.length;
         for(int i=0; i < polygon3Dpoints.length ; i++){   
        	 sum.z = sum.z + polygon3Dpoints[i].z;
	}
         center.z = sum.z / polygon3Dpoints.length;
         return center;
	}
	@Override
	public int compareTo(Polygon3D otherPolygon) {
		
		return -1*Double.compare(this.distancetocenter, otherPolygon.distancetocenter);
	}
}
