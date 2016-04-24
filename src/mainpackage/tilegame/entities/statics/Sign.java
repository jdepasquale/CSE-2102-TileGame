package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Sign extends StaticEntity{
	private int sn;
	
	public Sign(Handler handler, float x, float y, int signNumber){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT ));
		this.sn = signNumber;
		
		collisionBounds.x = width/8;
		collisionBounds.y = height/2;
		collisionBounds.width = width*3/4 ;
		collisionBounds.height = height/4 ;
		
		interactionBox.x = width/4;
		interactionBox.y = height;
		interactionBox.width = width/2;
		interactionBox.height = height/2;
	
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
