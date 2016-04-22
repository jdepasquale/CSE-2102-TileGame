package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Shrub extends StaticEntity{
	
	public Shrub(Handler handler, float x, float y ){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT *3/2));
		
		collisionBounds.x = 0;
		collisionBounds.y = height/2;
		collisionBounds.width = width ;
		collisionBounds.height = height/4 ;
	
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.shrub, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
}
