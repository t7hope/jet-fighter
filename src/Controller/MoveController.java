package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.Map;

public class MoveController implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// north jet move
		if (e.getKeyCode() == e.VK_S) {
			Map.moveNorthDown = true;
		}

		if (e.getKeyCode() == e.VK_A) {
			Map.moveNorthLeft = true;
		}

		if (e.getKeyCode() == e.VK_D) {
			Map.moveNorthRight = true;
		}

		if (e.getKeyCode() == e.VK_W) {
			Map.moveNorthUp = true;
		}

		// south jet move
		if (e.getKeyCode() == e.VK_DOWN) {
			Map.moveSouthDown = true;
		}

		if (e.getKeyCode() == e.VK_LEFT) {
			Map.moveSouthLeft = true;
		}

		if (e.getKeyCode() == e.VK_UP) {
			Map.moveSouthUp = true;
		}

		if (e.getKeyCode() == e.VK_RIGHT) {
			Map.moveSouthRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// north jet move
		if (e.getKeyCode() == e.VK_S) {
			Map.moveNorthDown = false;
		}

		if (e.getKeyCode() == e.VK_A) {
			Map.moveNorthLeft = false;
		}

		if (e.getKeyCode() == e.VK_D) {
			Map.moveNorthRight = false;
		}

		if (e.getKeyCode() == e.VK_W) {
			Map.moveNorthUp = false;
		}

		// south jet move
		if (e.getKeyCode() == e.VK_DOWN) {
			Map.moveSouthDown = false;
		}

		if (e.getKeyCode() == e.VK_LEFT) {
			Map.moveSouthLeft = false;
		}

		if (e.getKeyCode() == e.VK_UP) {
			Map.moveSouthUp = false;
		}

		if (e.getKeyCode() == e.VK_RIGHT) {
			Map.moveSouthRight = false;
		}
	}
}
