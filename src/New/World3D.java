import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class World3D implements Runnable {
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	Camera camera = new Camera();
	Frame window = new Frame();
	Thread r;

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
					b.distancetocenter= camera.position.distance(b.center());
				}
				Arrays.sort(a.faces);
				Polygon p = new Polygon();
				for (Point3D c : b.polygon3Dpoints) {
					Point2D.Double d = camera.turn2Dto3D(c);
					if (d != null) {
						if (d.x >= 1 || d.x <= -1) {
							d.x = Math.abs(d.x) / d.x;
						}
						p.addPoint(
								(int) (d.x * dim.height / 2) + dim.width / 2,
								(int) (d.y * dim.height / 2) + dim.height / 2);
					}
					
				}
				g.setColor(b.fillcolor);
				g.fillPolygon(p);
			}
		}
	}

	@Override
	public void run() {
		while (true) {
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
