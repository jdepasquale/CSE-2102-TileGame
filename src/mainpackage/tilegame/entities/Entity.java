package mainpackage.tilegame.entities;

import java.awt.Graphics;

import mainpackage.tilegame.Game;

public abstract class Entity {

	protected Game game;
	protected float x;  
	protected float y;
	//X & Y are positions, floats used to maintain smooth motion
	protected int width; 
	protected int height;
	//protected - private but accessible by class that extend the entity class
		
	
	public Entity(Game game, float x, float y, int width, int height){ 
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

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
