package mainpackage.tilegame.entities.Creatures;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.Entity;
import mainpackage.tilegame.tiles.Tile;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.5f;
	public static final int DEFAULT_CREATURE_WIDTH = 24*2; // Default creature size
	public static final int DEFAULT_CREATURE_HEIGHT = 30*2;
	
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	

	public Creature(Handler handler, float x, float y, int width, int height, String lastAnimDirection) {
		super(handler, x, y, width, height, lastAnimDirection); //X & Y extended from Entity class
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		
	}
	
	public void move(){
		if(!checkEntityCollisions(xMove,0f)){
			moveX();
		}
		if(!checkEntityCollisions(0f, yMove)){
			moveY();
		}
		
	}
	
	public void moveX(){
		if(xMove >0){//moving right
			int tempX = (int)(x+ xMove + collisionBounds.x + collisionBounds.width)/ Tile.TILEWIDTH;
			//if the upper right or lower left corner of the collision box is not solid the move
			if(!collisionWithTile(tempX, (int)(y + collisionBounds.y)/Tile.TILEHEIGHT) 
					&& !collisionWithTile(tempX, (int)(y + collisionBounds.y + collisionBounds.height)/Tile.TILEHEIGHT)){
				x += xMove;
			}
			else{
				x = tempX*Tile.TILEWIDTH - collisionBounds.x - collisionBounds.width -1 ;
			}
			
		}
		else if(xMove<0){// moving right
			int tempX = (int)(x+ xMove + collisionBounds.x )/ Tile.TILEWIDTH;
			//if the upper right or lower left corner of the collision box is not solid the move
			if(!collisionWithTile(tempX, (int)(y + collisionBounds.y)/Tile.TILEHEIGHT) 
					&& !collisionWithTile(tempX, (int)(y + collisionBounds.y + collisionBounds.height)/Tile.TILEHEIGHT)){
				x += xMove;
			}
			else{
				x = tempX*Tile.TILEWIDTH + Tile.TILEWIDTH - collisionBounds.x ;
			}
		}
		
	}
	public void moveY(){
		if(yMove < 0){// up
			int tempY = (int) (y+ yMove + collisionBounds.y)/Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + collisionBounds.x) / Tile.TILEHEIGHT, tempY) 
					&& !collisionWithTile((int)(x + collisionBounds.x + collisionBounds.width) / Tile.TILEHEIGHT, tempY)){
				y += yMove;
			}
			else{
				y = tempY *Tile.TILEHEIGHT + Tile.TILEHEIGHT - collisionBounds.y;
			}
		}
		else if(yMove > 0){//down
			int tempY = (int) (y+ yMove + collisionBounds.y + collisionBounds.height)/Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x + collisionBounds.x) / Tile.TILEHEIGHT, tempY) 
					&& !collisionWithTile((int)(x + collisionBounds.x + collisionBounds.width) / Tile.TILEHEIGHT, tempY)){
				y += yMove;
			}
			else{
				y = tempY *Tile.TILEHEIGHT - collisionBounds.y - collisionBounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
		
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
