package mainpackage.tilegame.entities.statics.item;

import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.statics.StaticEntity;

public abstract class Item extends StaticEntity{

	private int quantity;
	private String name;
	private BufferedImage itemImage;
	
	public Item(Handler handler, float x, float y, int width, int height, String name, int quantity, BufferedImage itemImage) {
		super(handler, x, y, width, height);
		//this.itemNum = itemNum;
	collisionBounds.x = 0; 
	collisionBounds.y = 0; 
	collisionBounds.width = width; 
	collisionBounds.height = height;
	
	interactionBox.x = 0; 
	interactionBox.y = 0; 
	interactionBox.width = width; 
	interactionBox.height = height;
	
	this.quantity = quantity;
	this.name = name;
	this.itemImage = itemImage;
	}

	public void add(){
		handler.getWorld().getEntityManager().getPlayer().getInventory().add(this);
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


	
	
}	