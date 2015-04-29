import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class World3D implements Runnable{
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
   ArrayList<Polygon3D> triList = new ArrayList<Polygon3D>();
	Camera camera = new Camera();
	Frame window = new Frame();
	Thread r;
   Point3D mover = new Point3D(.2,.2,.2);
   Point3D orienter = new Point3D(.02,.02,.02);
   Point3D viewpos = new Point3D(.02,.02,.02);
   boolean quit = false;

	public World3D() {
		GraphicsDevice g = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		window.setUndecorated(true);
		g.setFullScreenWindow(window);
		window.createBufferStrategy(2);
		window.setIgnoreRepaint(true);
		r = new Thread(this);
		r.start();
	}

	public void act() {
		
	}

	public void render(Graphics graphical) {
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		graphical.clearRect(0, 0, dim.width, dim.height);
		for (GameObject theObject : objects) {
			for (Polygon3D triangle : theObject.faces) {
				Polygon screenpoly = new Polygon();
            triList.add(triangle);
            for(int i=0; i<triList.size();i++){
               Point3D[] depthTriangle = new Point3D[3];
               int counter=0;
               for(Point3D 3dps: triList.at(i)){
                  double distfromcam = 3dps.distance(Camera);
                  Point2D 2dp = camera.turn2Dto3D(3dps); //returns a point (0 to .999, 0 to .999)
					   if (2dp != null) {
                     Point3D depthpoint = new Point3D(
                        (int) ((2dp.getX() * dim.getHeight() / 2) + dim.getWidth() / 2), //scales the point to scren
                        (int) ((2dp.getY() * dim.getHeight() / 2) + dim.getHeight() / 2), //scale by height cuz make box
                        distfromcam);
                     depthTriangle[counter] = depthpoint;
                     counter++;
                  }  
               }
               Plane3D zCalculator = new Plane3D(depthTriangle[0],depthTriangle[1],depthTriangle[2]);
               counter = 0;
            }
			}
		}
	}

	@Override
	public void run() {
   window.addKeyListener(new KeyListener(){
    private boolean pressed;
    private int pressedKey;
    @Override public void keyTyped(    final KeyEvent e){
      pressed=false;
      pressedKey=-1;
    }
    @Override public void keyPressed(    final KeyEvent e){
        pressedKey=e.getKeyCode();
        pressed=true;
        if(pressedKey == 87)
          camera.position.setZ(camera.position.getZ()+mover.getZ());
        if(pressedKey == 83)
          camera.position.setZ(camera.position.getZ()-mover.getZ());
        if(pressedKey == 65)
          camera.position.setX(camera.position.getX()+mover.getX());
        if(pressedKey == 68)
          camera.position.setX(camera.position.getX()-mover.getX());
        if(pressedKey == 69)
          camera.position.setY(camera.position.getY()+mover.getY());
        if(pressedKey == 81)
          camera.position.setY(camera.position.getY()-mover.getY());
        if(pressedKey == 73)
          camera.orientation.setZ(camera.orientation.getZ()+orienter.getZ());
        if(pressedKey == 75)
          camera.orientation.setZ(camera.orientation.getZ()-orienter.getZ());
        if(pressedKey == 74)
          camera.orientation.setX(camera.orientation.getX()+orienter.getX());
        if(pressedKey == 76)
          camera.orientation.setX(camera.orientation.getX()-orienter.getX());
        if(pressedKey == 79)
          camera.orientation.setY(camera.orientation.getY()+orienter.getY());
        if(pressedKey == 85)
          camera.orientation.setY(camera.orientation.getY()-orienter.getY());
        if(pressedKey == 84)
          camera.viewposition.setZ(camera.viewposition.getZ()+viewpos.getZ());
        if(pressedKey == 71)
          camera.viewposition.setZ(camera.viewposition.getZ()-viewpos.getZ());
        System.out.println(camera.orientation);
        if(pressedKey == 27)
          quit = true;
//        System.out.println("Key_Pressed");
    }
    
    @Override public void keyReleased(    final KeyEvent e){
      pressed=false;
    }
    
  });
      
      while (true) {
			 if(quit)
            System.exit(0);
          try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			act();
			for (GameObject a : objects) {
				a.act();
			}
         Graphics g = window.getBufferStrategy().getDrawGraphics();
			render(g);
			g.dispose();
         window.getBufferStrategy().show();
		}
      
	};

}
