package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import Controller.MoveController;
import Controller.ShootController;
import Model.Bullet;
import Model.Hp;
import Model.Jet;

public class Map extends JPanel implements Runnable {
	public static Bullet bullet;
	public static Jet northJet, southJet;
	public static Hp northJetHpbackground, southJetHpbackground;
	public static Hp northJetHp, southJetHp;
	public static boolean moveNorthLeft, moveNorthRight, moveNorthUp, moveNorthDown, northFire, northSpecial;
	public static boolean moveSouthLeft, moveSouthRight, moveSouthUp, moveSouthDown, southFire, southSpecial;
	private Thread loop; // the loop
	private ArrayList<Bullet> northBullets, southBullets;
	private int reload, numToShoot;

	// constructor
	public Map() {
		init();
		setPreferredSize(new Dimension(App.WIDTH, App.HEIGHT));
		addKeyListener(new MoveController());
		addKeyListener(new ShootController());
		addMouseListener(new Mouse());
		setFocusable(true);
		setBackground(new Color(0, 0, 0));
		setDoubleBuffered(true);
		setFocusable(true);

	}

	private void init() {
		northJet = new Jet(App.WIDTH / 2 - 10, 0, 20, 40, 2);
		southJet = new Jet(App.WIDTH / 2 - 10, App.HEIGHT - 200, 20, 40, 2);
		moveNorthLeft = moveNorthRight = moveNorthUp = moveNorthDown = northFire = northSpecial = false;
		moveSouthLeft = moveSouthRight = moveSouthUp = moveSouthDown = southFire = southSpecial = false;
		bullet = new Bullet(0, 0, 0, 0);
		northBullets = northJet.getBullets();
		southBullets = southJet.getBullets();
		reload = 10;
		numToShoot = 1;

		//north jet hp
		northJetHpbackground = new Hp(3, App.HEIGHT / 2 - 32, 200, 30);
		northJetHp = new Hp(3, App.HEIGHT / 2 - 32, 200, 30);

		//south jet hp
		southJetHpbackground = new Hp(App.WIDTH - 201, App.HEIGHT / 2 + 2, 200, 30);
		southJetHp = new Hp(App.WIDTH - 201, App.HEIGHT / 2 + 2, 200, 30);
		loop = new Thread(this);
		loop.start();

	}

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		///// drawing
		g2d.setColor(Color.blue);
		g2d.drawLine(0, App.HEIGHT / 2, App.WIDTH / 2, App.HEIGHT / 2);

		g2d.setColor(Color.red);
		g2d.setFont(new Font("Arial", Font.BOLD, 30));
		g2d.drawString("VS", App.WIDTH / 2, App.HEIGHT / 2);

		g2d.setColor(Color.blue);
		g2d.drawLine(App.WIDTH / 2 + 35, App.HEIGHT / 2, App.WIDTH, App.HEIGHT / 2);

		// north hp
		g2d.setColor(Color.red);
		g2d.drawRect(northJetHpbackground.getX(), northJetHpbackground.getY(), (int) northJetHpbackground.getWidth(),
				northJetHpbackground.getHeight());
		g2d.setColor(Color.GREEN);
		g2d.fillRect(northJetHp.getX(), northJetHp.getY(), (int) northJetHp.getWidth(), northJetHp.getHeight());

		// south hp
		g2d.setColor(Color.red);
		g2d.drawRect(southJetHpbackground.getX(), southJetHpbackground.getY(), (int) southJetHpbackground.getWidth(),
				southJetHpbackground.getHeight());
		g2d.setColor(Color.GREEN);
		g2d.fillRect(southJetHp.getX(), southJetHp.getY(), (int) southJetHp.getWidth(), southJetHp.getHeight());
		//north jet
		g2d.setColor(Color.RED);
		g2d.drawRect((int) northJet.getX(), (int) northJet.getY(), northJet.getW(), northJet.getH());
		g2d.drawPolygon(new int[] {(int) northJet.getX() - 25, (int) northJet.getX(), (int) northJet.getX()}, 
						new int[] {(int) northJet.getY(), (int) northJet.getY(), (int) northJet.getY() + 15}, 3);
		g2d.drawPolygon(new int[] {(int) northJet.getX() + (int) northJet.getW(), (int) northJet.getX() + (int) northJet.getW() + 25, (int) northJet.getX() + (int) northJet.getW()}, 
						new int[] {(int) northJet.getY(), (int) northJet.getY(), (int) northJet.getY() + 15}, 3);
		g2d.drawPolygon(new int[] {(int) northJet.getX(), (int) northJet.getX() + (int) northJet.getW(), (int) northJet.getX() + (int) northJet.getW() / 2}, 
						new int[] {(int) northJet.getY() + northJet.getH(), (int) northJet.getY() + (int) northJet.getH(), (int) northJet.getY() + (int) northJet.getH() + 15}, 3);
		
		//south jet
		g2d.drawRect((int) southJet.getX(), (int) southJet.getY(), southJet.getW(), southJet.getH());
		g2d.drawPolygon(new int[] {(int) southJet.getX() - 25, (int) southJet.getX(), (int) southJet.getX()}, 
						new int[] {(int) southJet.getY() + (int) southJet.getH(), (int) southJet.getY() + (int) southJet.getH(), (int) southJet.getY() + 25}, 3);
		g2d.drawPolygon(new int[] {(int) southJet.getX() + (int) southJet.getW() + 25, (int) southJet.getX() + (int) southJet.getW(), (int) southJet.getX() + (int) southJet.getW()}, 
						new int[] {(int) southJet.getY() + (int) southJet.getH(), (int) southJet.getY() + (int) southJet.getH(), (int) southJet.getY() + 25}, 3);
		g2d.drawPolygon(new int[] {(int) southJet.getX(), (int) southJet.getX() + (int) southJet.getW(), (int) southJet.getX() + (int) southJet.getW() / 2}, 
						new int[] {(int) southJet.getY(), (int) southJet.getY(), (int) southJet.getY() - 15}, 3);
		//boundary
		//g2d.drawLine(0, App.HEIGHT / 2, App.WIDTH, App.HEIGHT / 2);
		
		///// drawing the bullets
		// north bullets
		ArrayList<Bullet> northBullets = northJet.getBullets();
		for (int i = 0; i < northBullets.size(); i++) {
			Bullet bullet = (Bullet) northBullets.get(i);
			// setting bullet colors
			g2d.setColor(Color.CYAN);
			g2d.fillRect((int) bullet.getX(), (int) bullet.getY(), bullet.getW(), bullet.getH());
		}

		// south bullets
		ArrayList<Bullet> southBullets = southJet.getBullets();
		for (int i = 0; i < southBullets.size(); i++) {
			Bullet bullet = (Bullet) southBullets.get(i);
			// setting bullet colors
			g2d.setColor(Color.RED);
			g2d.fillRect((int) bullet.getX(), (int) bullet.getY(), bullet.getW(), bullet.getH());
		}
	}

	public void play() {
		///// moving jet
		// north jet
		if (moveNorthLeft) {
			northJet.move(1, 1);
		}

		if (moveNorthRight) {
			northJet.move(1, 2);
		}

		if (moveNorthUp) {
			northJet.move(1, 3);
		}

		if (moveNorthDown) {
			northJet.move(1, 4);
		}

		// south jet
		if (moveSouthLeft) {
			southJet.move(2, 1);
		}

		if (moveSouthRight) {
			southJet.move(2, 2);
		}

		if (moveSouthUp) {
			southJet.move(2, 3);
		}

		if (moveSouthDown) {
			southJet.move(2, 4);
		}

		///// check if shooting
		if (northFire) {
			northJet.fire(reload, numToShoot, 1);
		}

		if (southFire) {
			southJet.fire(reload, numToShoot, 2);
		}

		///// moving bullets
		// north bullets
		ArrayList<Bullet> northBullets = northJet.getBullets();
		for (int i = 0; i < northBullets.size(); i++) {
			Bullet bullet = (Bullet) northBullets.get(i);

			bullet.move(1, 2);

			if (bullet.getX() > App.WIDTH || bullet.getX() < 0 || bullet.getY() > App.HEIGHT || bullet.getY() < 0) {
				northBullets.remove(i);
			}

		}

		// south bullets
		ArrayList<Bullet> southBullets = southJet.getBullets();
		for (int i = 0; i < southBullets.size(); i++) {
			Bullet bullet = (Bullet) southBullets.get(i);

			bullet.move(2, 5);

			if (bullet.getX() > App.WIDTH || bullet.getX() < 0 || bullet.getY() > App.HEIGHT || bullet.getY() < 0) {
				southBullets.remove(i);
			}

		}

	}

	// mouse control
	private class Mouse extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if (e.getButton() == e.BUTTON1) {
				northFire = true;
			}
			if (e.getButton() == e.BUTTON3) {
				northSpecial = true;
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == e.BUTTON1) {
				northFire = false;
			}
			if (e.getButton() == e.BUTTON3) {
				northSpecial = false;
			}

		}
	}

	// the wors game loop ever
	@Override
	public void run() {
		while (true) {
			repaint();
			play();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}