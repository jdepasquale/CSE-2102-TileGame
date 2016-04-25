package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;

public class Chest extends StaticEntity{

	private long lastTime;
	private long timer;
	private boolean isOpen;
	private int imageNum;

	public Chest(Handler handler, float x, float y) {
		super(handler, x, y, 22*3, 20*3);
		collisionBounds.x = 0;
		collisionBounds.y = height*2/3;
		collisionBounds.width = width*3/4+3;
		collisionBounds.height =  height/8;

		interactionBox.x = -width/8; 
		interactionBox.y = height*2/3; 
		interactionBox.width = width*2/3; 
		interactionBox.height = height/2;
		
		timer = 0;
		lastTime = System.currentTimeMillis();
		this.imageNum = 0;
		this.isOpen = false;
	}

	public boolean isOpen() {
		return isOpen;
	}
	
	public void open(){
		
		this.isOpen = true;	
	
	}
	
	@Override
	public void update() {
		
		if(isOpen){
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			if(timer > 23 && imageNum <6){
				imageNum = imageNum+1;
				collisionBounds.width = width;
				timer = 0;
			}
			
		}

	}


	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.chest[imageNum], (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	


}
