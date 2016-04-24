package mainpackage.tilegame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import mainpackage.tilegame.Handler;

public abstract class Entity {

	protected Handler handler;                                                           ;
	protected float x;  
	protected float y;
	//X & Y are positions, floats used to maintain smooth motion
	protected int width; 
	protected int height;
	//protected - private but accessible by class that extend the entity class
	protected Rectangle collisionBounds; 
	protected Rectangle interactionBox; 
	
	


	public Entity(Handler handler, float x, float y, int width, int height){ 
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		collisionBounds = new Rectangle(0, 0, width, height);
		interactionBox = new Rectangle(0, 0, width, height);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				return true;
			}
		}
		return false;
	}
	
	//GETTERS&SETTERS
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle ((int)(x + collisionBounds.x + xOffset), (int) (y + collisionBounds.y + yOffset), collisionBounds.width, collisionBounds.height);
	}

	public Rectangle getInteractionBox(float xOffset, float yOffset) {
		return new Rectangle ((int)(x + interactionBox.x + xOffset), (int) (y + interactionBox.y + yOffset), interactionBox.width, interactionBox.height);
	}

	public void setInteractionBox(Rectangle interactionBox) {
		this.interactionBox = interactionBox;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
