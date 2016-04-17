package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Iceberg extends StaticEntity{
	
	public Iceberg(Handler handler, float x, float y, String lastAnimDirection ){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT), lastAnimDirection);
		
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
	g.drawImage(Assets.iceberg, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
}