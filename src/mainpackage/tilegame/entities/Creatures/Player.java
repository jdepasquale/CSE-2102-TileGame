package mainpackage.tilegame.entities.Creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Animation;
import mainpackage.tilegame.gfx.Assets;

public class Player extends Creature {

	//Animations
	private Animation downAnim;
	private Animation downStandAnim;
	private Animation upAnim;	
	private Animation upStandAnim;
	private Animation leftAnim;
	private Animation leftStandAnim;
	private Animation rightAnim;
	private Animation rightStandAnim;
	
	
	
	
	
	public Player(Handler handler, float x, float y,  String lastAnimDirection) {
		//sets starting location and creature size 
		super(handler, x, y, (Creature.DEFAULT_CREATURE_WIDTH ), Creature.DEFAULT_CREATURE_HEIGHT, lastAnimDirection);
		
		// these should be in relation to the player width/ height
		collisionBounds.x = 6*2; 
		collisionBounds.y = 18*2; 
		collisionBounds.width = 24; 
		collisionBounds.height = 23;
		
		interactionBox.x = 0; 
		interactionBox.y = 0; 
		interactionBox.width = width; 
		interactionBox.height = height;
		
		//Animations
		downAnim = new Animation(250, Assets.playerV1D);
		downStandAnim = new Animation(600, Assets.playerV1DS);
		upAnim = new Animation(250, Assets.playerV1U);	
		upStandAnim = new Animation(600, Assets.playerV1US);
		leftAnim = new Animation(100, Assets.playerV1L);
		leftStandAnim = new Animation(600, Assets.playerV1LS);
		rightAnim = new Animation(100, Assets.playerV1R);
		rightStandAnim = new Animation(600, Assets.playerV1RS);
	}

	@Override
	public void update() {
		//Animations
		downAnim.update();
		downStandAnim.update();
		upAnim.update();
		upStandAnim.update();
		leftAnim.update();
		leftStandAnim.update();
		rightAnim.update();
		rightStandAnim.update();
		
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right){
			xMove = speed;
		}
		
	}
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
		
	/*//collision rectangle
		g.setColor(Color.red);
		g.fillRect((int)(x + collisionBounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
				collisionBounds.width, collisionBounds.height);
	//player interaction box
		g.setColor(Color.red);
		g.fillRect((int)(x + interactionBox.x - handler.getGameCamera().getxOffset()),
				(int) (y + interactionBox.y - handler.getGameCamera().getyOffset()),
				interactionBox.width, interactionBox.height);
	*/
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
		else if(this.getLastAnimDirection() == "U"){
			return upStandAnim.getCurrentFrame();
		}
		else if(this.getLastAnimDirection() == "L"){
			return leftStandAnim.getCurrentFrame();
		}
		else if(this.getLastAnimDirection() == "R"){
			return rightStandAnim.getCurrentFrame();
		}
		else{	
			return downStandAnim.getCurrentFrame();
		}
	}
	

}
