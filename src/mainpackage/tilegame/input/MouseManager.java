package mainpackage.tilegame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftPressed;
	private boolean rightPressed;
	private int mouseX; //locatiion on screen
	private int mouseY; //locatiion on screen
	
	
	public MouseManager(){
		
	}
	
	
	
	
	//Implemented methods

	@Override
	public void mousePressed(MouseEvent mE) {
		if (mE.getButton() == MouseEvent.BUTTON1){ //Left button 
			leftPressed = true;
		}
		else if(mE.getButton() == MouseEvent.BUTTON3){ // right button
			rightPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent mE) {
		if (mE.getButton() == MouseEvent.BUTTON1){ //Left button 
			leftPressed = false;
		}
		else if(mE.getButton() == MouseEvent.BUTTON3){ // right button
			rightPressed = false;
		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent mE) {
		mouseX = mE.getX();
		mouseY = mE.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent mE) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent mE) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent mE) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent mE) {
		// TODO Auto-generated method stub
		
	}

	//GETTERS&SETTERS
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
}
