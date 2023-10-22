package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.Map;

public class ShootController implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_J) {
			Map.northFire = true;
		}
		
		if (e.getKeyCode() == e.VK_END) {
			Map.southFire = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_J) {
			Map.northFire = false;
		}
		
		if (e.getKeyCode() == e.VK_END) {
			Map.southFire = false;
		}
	}
	
}
