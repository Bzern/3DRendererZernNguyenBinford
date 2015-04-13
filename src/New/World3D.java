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

	public void render(Graphics g) {
		Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		g.clearRect(0, 0, dim.width, dim.height);
		for (GameObject a : objects) {
			for (Polygon3D b : a.faces) {
				for(int i=0; i<a.faces.length; i++){
					b.setDistancetocenter(camera.position.distance(b.center()));
				}
				Arrays.sort(a.faces);
				Polygon p = new Polygon();
				for (Point3D c : b.getPolygon3Dpoints()) {
					Point2D d = camera.turn2Dto3D(c);
					if (d != null) {
						if (d.getX() >= 1 || d.getX() <= -1) {
							d.setX(Math.abs(d.getX()) / d.getX());
						}
						p.addPoint(
								(int) ((d.getX() * dim.getHeight() / 2) + dim.getWidth() / 2),
								(int) ((d.getY() * dim.getHeight() / 2) + dim.getHeight() / 2));
					}
					
				}
				g.setColor(b.getFillcolor());
				g.fillPolygon(p);
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
