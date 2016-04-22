package mainpackage.tilegame.tiles;

import mainpackage.tilegame.graphics.Assets;

public class Ice1Tile extends Tile {

	public Ice1Tile(int id) {
		super(Assets.ice1, id);
		
	}
	@Override
	public boolean isSolid(){ //id rather call this is walkable and return false, this would change collisions though...
		return true; //you can not walk through  this tile
	}
	
}
