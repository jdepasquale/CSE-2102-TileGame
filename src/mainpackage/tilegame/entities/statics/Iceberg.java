package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Iceberg extends StaticEntity{
	
	public Iceberg(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT));
		
		collisionBounds.x = width/8;
		collisionBounds.y = height/2;
		collisionBounds.width = width/4*3;
		collisionBounds.height = (height)/2;
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.iceberg, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
}
