package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;
import mainpackage.tilegame.tiles.Tile;

public class SandMound extends StaticEntity{
	
	public SandMound(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT/2 ));
		collisionBounds.x = 0;
		collisionBounds.y = 0;
		collisionBounds.width = 0;
		collisionBounds.height = 0;
	}
	

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.sandMound, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);

	}
	
}
