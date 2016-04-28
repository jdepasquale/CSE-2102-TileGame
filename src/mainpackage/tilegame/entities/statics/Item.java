package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.statics.StaticEntity;
import mainpackage.tilegame.graphics.Assets;

public class Item extends StaticEntity{

	private int quantity;
	private String name;
	private BufferedImage itemImage;
	private boolean found;
	private long lastTime;
	private long timer;
	private boolean drawFoundIt;


	public Item(Handler handler, float x, float y, int width, int height, String name, int quantity, BufferedImage itemImage) {
		super(handler, x, y, width, height);

		collisionBounds.x = 0; 
		collisionBounds.y = 0; 
		collisionBounds.width = 0; 
		collisionBounds.height = 0;

		interactionBox.x = width/4; 
		interactionBox.y = -height/4; 
		interactionBox.width = width/2; 
		interactionBox.height = 1;

	
		
		this.quantity = quantity;
		this.name = name;
		this.itemImage = itemImage;
		this.found = false;
		this.drawFoundIt = false;
	}

	public void add(){
		this.setX(0);
		this.setY(0);
		this.setWidth(32);
		this.setHeight(32);
		handler.getWorld().getEntityManager().getPlayer().getInventory().add(this);
		this.timer = 0;
		this.lastTime = System.currentTimeMillis();

	}

	@Override
	public void update() {
		
		
		
		if(found){
			this.timer += System.currentTimeMillis() - lastTime;
			this.lastTime = System.currentTimeMillis();
			if(timer < 2500){
				if((timer%(1000/60)) < (1000/120)){
					drawFoundIt = true;
				}
				else{
					drawFoundIt = false;
				}
			}
			else{
				drawFoundIt = false;
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		if(!found){
			g.drawImage(itemImage, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		}
		if(drawFoundIt){
			g.drawImage(Assets.newItemImage, 42,375, null);
		}
		
	}
	
	//GETTERS&SETTERS
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BufferedImage getItemImage() {
		return itemImage;
	}


	public void setItemImage(BufferedImage itemImage) {
		this.itemImage = itemImage;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}


	
	
}	