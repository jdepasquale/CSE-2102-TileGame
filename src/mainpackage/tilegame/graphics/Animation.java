package mainpackage.tilegame.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	private int swapSpeed;
	private int index;
	private long lastTime;
	private long timer;
	private BufferedImage[] frames;
	//private String animDirection; // D-down, U-up, L-left, R-Right
	
	public Animation(int swapSpeed, BufferedImage[] frames){
		this.swapSpeed = swapSpeed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		//this.animDirection = aminDirection;
	}
	
	public void update(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if (timer > swapSpeed){
			index ++;
			timer = 0;
			if( index >= frames.length){
				index = 0;
			}
		}
	}
	
	//GETTERS&SETTERS
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
}
