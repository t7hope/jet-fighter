package test;

import java.awt.Color;

import javax.swing.JFrame;

public class RotateME extends JFrame {

	public static final int WIDTH = 800, HEIGHT = 600;

	public RotateME() {

		add(new Board());

		setTitle("rotate me please");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);

	}

	public static void main(String[] args) {
		new RotateME();

	}

}