package mainpackage.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Animation;
import mainpackage.tilegame.graphics.Assets;

public class RedBlob extends Creature{
	
	//Animations
		private Animation downAnim;
		private Animation upAnim;
		private Animation leftAnim;
		private Animation rightAnim;
		

	public RedBlob(Handler handler, float x, float y, String lastAnimDirection) {
		super(handler, x, y, 16*2,24*2, lastAnimDirection);
		collisionBounds.x = 8; 
		collisionBounds.y = 0; 
		collisionBounds.width = 16; 
		collisionBounds.height = 24;
		
		interactionBox.x = -width/2; 
		interactionBox.y = -height/2; 
		interactionBox.width = width*2; 
		interactionBox.height = height*3/2;
		
		//animations 
		downAnim = new Animation(300, Assets.redBlobD);
		upAnim = new Animation(300, Assets.redBlobU);
		leftAnim = new Animation(300, Assets.redBlobL);
		rightAnim = new Animation(300, Assets.redBlobR);
	
	
	}

	@Override
	public void update() {
		
		downAnim.update();
		upAnim.update();	
		leftAnim.update();
		rightAnim.update();
		move();

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	
	private BufferedImage getCurrentAnimationFrame(){
		
		if(xMove < 0 ){
			this.setLastAnimDirection("L");
			return leftAnim.getCurrentFrame();
		}
		else if(xMove > 0){
		
			this.setLastAnimDirection("R");
			return rightAnim.getCurrentFrame();
		}
	 
		else if(yMove < 0){
			this.setLastAnimDirection("U");
			return upAnim.getCurrentFrame();
		} 
		else if(yMove> 0){
			this.setLastAnimDirection("D");
			return downAnim.getCurrentFrame();
		}
		else{
			this.setLastAnimDirection("D");
			return  downAnim.getCurrentFrame();
		}
	}
	

}
