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
	
	protected String lastAnimDirection;
	
	


	public Entity(Handler handler, float x, float y, int width, int height, String lastAnimDirection){ 
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.lastAnimDirection = lastAnimDirection;
		
		collisionBounds = new Rectangle(0, 0, width, height);
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
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle ((int)(x + collisionBounds.x + xOffset), (int) (y + collisionBounds.y + yOffset), collisionBounds.width, collisionBounds.height);
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
	
	public String getLastAnimDirection() {
		return lastAnimDirection;
	}

	public void setLastAnimDirection(String lastAnimDirection) {
		this.lastAnimDirection = lastAnimDirection;
	}
	
}
