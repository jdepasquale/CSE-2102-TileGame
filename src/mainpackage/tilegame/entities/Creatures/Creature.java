package mainpackage.tilegame.entities.Creatures;

import mainpackage.tilegame.Game;
import mainpackage.tilegame.entities.Entity;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 16; // Default creature size
	public static final int DEFAULT_CREATURE_HEIGHT = 16;
	
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;

	public Creature(Game game, float x, float y, int width, int height) {
		super(game, x, y, width, height); //X & Y extended from Entity class
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		
	}
	
	public void move(){
		x += xMove;
		y += yMove;
	}
	
	//Getters and setters
	public float getXMove() {
		return xMove;
	}

	public void setXMove(float xMove) {
		this.xMove = xMove;
	}

	public float getYMove() {
		return yMove;
	}

	public void setYMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}


}
