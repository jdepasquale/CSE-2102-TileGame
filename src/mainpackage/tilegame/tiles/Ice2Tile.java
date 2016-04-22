package mainpackage.tilegame.tiles;

import mainpackage.tilegame.graphics.Assets;

public class Ice2Tile extends Tile {

	public Ice2Tile(int id) {
		super(Assets.ice2, id);
	
	}
	@Override
	public boolean isSolid(){ //id rather call this is walkable and return false, this would change collisions though...
		return true; //you can not walk through  this tile
	}
}
