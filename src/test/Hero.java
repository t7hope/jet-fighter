package test;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Hero {

	private double x, y, a; // x,y and angle
	private int w, h, tmpLoad; // width and height and reloading counter (for
								// shooting)

	private ArrayList bullets; // this will hold our bullets

	private String img = "res/hero.png"; // this is the path of the image
	private Image image; // and this is the image

	// constructor
	public Hero(double x, double y, double a, int w, int h) {

		this.x = x;
		this.y = y;
		this.a = a;
		this.w = w;
		this.h = h;

		bullets = new ArrayList();
		tmpLoad = 0;

		ImageIcon ii = new ImageIcon(img);
		image = ii.getImage();
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

	public double getA() {
		return a;
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

	public ArrayList getBullets() {
		return bullets;
	}

	// setting the values
	public void setA(int aa) {

		a = Math.toRadians(aa);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	// move toward the angle
	// //forward
	public void moveForward(int sx, int sy) {
		x += Math.cos(a) * sx;
		y += Math.sin(a) * sy;
	}

	// //backward
	public void moveBackword(int sx, int sy) {
		x -= Math.cos(a) * sx;
		y -= Math.sin(a) * sy;
	}

	/*
	 * firing load = how much time you wait between 2 bullets number = how many
	 * bullet you shot in a single shot spread = distance between 2 bullets
	 */
	public void fire(int load, int number, int spread) {

		// if reloading time is done
		if (tmpLoad == 0) {

			for (int i = 0; i < number; i++) {
				// setting the bullet
				Board.bullet.setX(x + w);
				Board.bullet.setY(y + h / 2);
				Board.bullet.setA(a + ((spread * (i - 1)) / 2));
				Board.bullet.setW(5);
				Board.bullet.setH(5);
				// adding the bullet to the array list
				bullets.add(new Bullet(Board.bullet.getX(), Board.bullet.getY(), Board.bullet.getA(),
						Board.bullet.getW(), Board.bullet.getH()));
			}
			// reset the reload time
			tmpLoad = load;
		} else {
			tmpLoad -= 1;

		}

	}
}