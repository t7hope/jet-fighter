package Model;

public class Bullet {

	private double x, y;
	private int w, h; // width and height

	public Bullet(double x, double y, int w, int h) {

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
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

	// moving bullet
	public void move(int jet, int speed) {
		//jet 1:north, 2:south
		if (jet == 1) {			
			y += speed;
		} else {
			y -= speed;
		}
	}

}
