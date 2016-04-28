package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;
import mainpackage.tilegame.tiles.Tile;

public class Tree extends StaticEntity{
	
	public Tree(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH*4, (Tile.TILEHEIGHT *4));
		
		collisionBounds.x = 100;
		collisionBounds.y = (int) (height *2/3f + 12);
		collisionBounds.width = Tile.TILEWIDTH;
		collisionBounds.height = Tile.TILEHEIGHT -24;
	
	}

	@Override
	public void update() {
	
		
	}

	@Override
	public void render(Graphics g) {
	g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);	
	
	}
	
}
