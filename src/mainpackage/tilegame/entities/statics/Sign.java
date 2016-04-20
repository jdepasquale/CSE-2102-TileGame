package mainpackage.tilegame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Sign extends StaticEntity{
	private int sn;
	
	public Sign(Handler handler, float x, float y, int signNumber){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT *3/2));
		this.sn = signNumber;
		
		collisionBounds.x = width/8;
		collisionBounds.y = height/2;
		collisionBounds.width = width*3/4 ;
		collisionBounds.height = height/4 ;
		
		interactionBox.x = -width/2;
		interactionBox.y = height/2;
		interactionBox.width = width*2;
		interactionBox.height = height;
	
	}
	
	public int getSignNumber(){
		return sn;
	}
	
	
	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.sign, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
	/*
	 * 
	 //sign intaraction box
	g.setColor(Color.blue);
	g.fillRect((int)(x + interactionBox.x - handler.getGameCamera().getxOffset()),
			(int) (y + interactionBox.y - handler.getGameCamera().getyOffset()),
			interactionBox.width, interactionBox.height);
	*/
	}
	
}
