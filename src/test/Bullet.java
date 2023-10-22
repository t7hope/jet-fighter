package test;

public class Bullet {

	private double x, y, a; // x,y and angle
	private int w, h; // width and height

	// constructor
	public Bullet(double x, double y, double a, int w, int h) {

		this.x = x;
		this.y = y;
		this.a = a;
		this.w = w;
		this.h = h;
	}

	// returning all the necessary value of this class

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

	// setting the values
	public void setA(double aa) {

		this.a = aa;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

	// move toward the angle
	// //forward
	public void moveForward(int speed) {
		x += Math.cos(a) * speed;
		y += Math.sin(a) * speed;
	}

}
