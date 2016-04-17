package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Rock1 extends StaticEntity{
	
	public Rock1(Handler handler, float x, float y, String lastAnimDirection ){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT *2), lastAnimDirection);
		
		collisionBounds.x = 0;
		collisionBounds.y = 0;
		collisionBounds.width = width ;
		collisionBounds.height = height ;
	
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.rock1, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
}
