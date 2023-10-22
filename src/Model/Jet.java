package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import View.App;
import View.Map;

public class Jet {

	private double x, y;
	private int w, h, tmpLoad; // width and height and reloading counter
	private int speed;
	private ArrayList<Bullet> bullets;
	private Image image;

	// constructor
	public Jet(double x, double y, int w, int h, int speed) {

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.speed = speed;

		bullets = new ArrayList<Bullet>();
		tmpLoad = 0;
	}

	// returning all the necessary value of this class

	public Image getI() {
		return image;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, w, h);
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void move(int jet, int direction) {
		//jet 1:north, 2:south
		//direction 1:left, 2:right, 3:up, 4:down
		if (jet == 1) {
			if (direction == 1) {
				if (x > 0) {
					x -= speed;
				}
			} else if (direction == 2) {
				if (x < App.WIDTH - w) {
					x += speed;
				}
			} else if (direction == 3) {
				if (y > 0) {
					y -= speed;
				}
			} else {
				if (y < App.HEIGHT / 2 - h - 15) {
					y += speed;
				}
			}
		} else {
			if (direction == 1) {
				if (x > 0) {
					x -= speed;
				}
			} else if (direction == 2) {
				if (x < App.WIDTH - w) {
					x += speed;
				}
			} else if (direction == 3) {
				if (y > App.HEIGHT / 2 + 15) {
					y -= speed;
				}
			} else {
				if (y < App.HEIGHT - h) {
					y += speed;
				}
			}
		}
	}

	public void fire(int load, int number, int jet) {
		// if reloading time is done
		if (tmpLoad == 0) {
			//jet 1:north, 2:south
			if (jet == 1) {
				for (int i = 0; i < number; i++) {
					// setting the bullet
					Map.bullet.setX(x + w / 2 - 5);
					Map.bullet.setY(y + h + 10);
					Map.bullet.setW(10);
					Map.bullet.setH(10);
					
					// adding the bullet to the array list
					bullets.add(new Bullet(Map.bullet.getX(), Map.bullet.getY(),
							Map.bullet.getW(), Map.bullet.getH()));
				}
			} else {
				for (int i = 0; i < number; i++) {
					// setting the bullet
					Map.bullet.setX(x + w / 2 - 5);
					Map.bullet.setY(y - 15);
					Map.bullet.setW(10);
					Map.bullet.setH(10);
					
					// adding the bullet to the array list
					bullets.add(new Bullet(Map.bullet.getX(), Map.bullet.getY(),
							Map.bullet.getW(), Map.bullet.getH()));
				}
			}
			// reset the reload time
			tmpLoad = load;
		} else {
			tmpLoad -= 1;
		}
	}
}