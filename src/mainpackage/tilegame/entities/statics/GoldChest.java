package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;

public class GoldChest extends Chest{
	private long lastTime;
	private long timer;
	private boolean isOpen;
	private int imageNum;
	public GoldChest(Handler handler, float x, float y) {
		super(handler, x, y);
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
	
	public void open(){
		//check if player has key
		if(hasKey()){
			this.isOpen = true;
		}
		else{
			//output -> key is needed
		}
	}
	
	private boolean hasKey() {
		if(handler.getWorld().getEntityManager().getPlayer().getInventory() != null){
			for(int i = 0 ; i < handler.getWorld().getEntityManager().getPlayer().getInventory().size() ; i ++){
				if(handler.getWorld().getEntityManager().getPlayer().getInventory().get(i).getName().equals("goldKey")){
					return true;
				}
			}
		}
		return false;
	}

	public boolean isOpen() {
		return isOpen;
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
	public void render(Graphics g){
		g.drawImage(Assets.goldChest[imageNum], (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}