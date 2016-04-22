package mainpackage.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, space, enter, s,c, q, p;
	int kp1;
	
	public KeyManager(){
		keys = new boolean[512];
	}
	
	public void update(){
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
		enter = keys[KeyEvent.VK_ENTER];
		s = keys[KeyEvent.VK_S];
		c = keys[KeyEvent.VK_C];
		q = keys[KeyEvent.VK_Q];
		p = keys[KeyEvent.VK_P];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed!");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		System.out.println("re!");
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	
	public boolean keyPressedOnce(boolean a){
		if(!a){
			kp1 = kp1 +1;
		}
		if(kp1 == 1 && a){
			kp1 = 0;
			return true;
		}
		return false;
	}
	
	

}
