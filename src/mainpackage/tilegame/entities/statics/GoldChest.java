package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.equipment.Equipment;
import mainpackage.tilegame.graphics.Assets;

public class GoldChest extends Chest{
	
	private long lastTime;
	private long timer;
	private long timer2;
	private long lastTime2;
	private boolean isOpen;
	private int imageNum;
	private boolean openAttempt;
	private boolean drawIt;
	
	public GoldChest(Handler handler, float x, float y, Item stuff, Equipment equipmentItem) {
		super(handler, x, y, stuff, equipmentItem);
		collisionBounds.x = 0;
		collisionBounds.y = height*2/3;
		collisionBounds.width = width*3/4+3;
		collisionBounds.height =  height/8;

		interactionBox.x = -width/8; 
		interactionBox.y = height*2/3; 
		interactionBox.width = width*2/3; 
		interactionBox.height = height/2;
		
		this.timer = 0;
		this.lastTime = System.currentTimeMillis();
		this.imageNum = 0;
		this.isOpen = false;
		this.openAttempt = false;
		this.drawIt = false;
	}
	
	
	public void open(){
		//check if player has key
		if(hasKey()){
			this.isOpen = true;
		}
		else{
			//output -> key is needed
			this.openAttempt = true;
			this.lastTime2 = System.currentTimeMillis();
			this.timer2 = 0;
				
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
		
		if(openAttempt){
			drawIt = true;
			timer2 += System.currentTimeMillis() - lastTime2;
			lastTime2 = System.currentTimeMillis();
			if(timer2 > 3000){
				drawIt = false;
				openAttempt = false;
			}
		
		}

	}
	@Override
	public void render(Graphics g){
		g.drawImage(Assets.goldChest[imageNum], (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
	
		if(drawIt){
			g.drawImage(Assets.keyNeededImage, 42,375, null);
		}
	}
}