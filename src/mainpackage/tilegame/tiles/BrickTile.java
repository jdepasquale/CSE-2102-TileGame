package mainpackage.tilegame.tiles;

import mainpackage.tilegame.graphics.Assets;

public class BrickTile extends Tile {
	
	public BrickTile(int id) {
		super(Assets.brick, id);

	}
	@Override
	public boolean isSolid(){ //id rather call this is walkable and return false, this would change collisions though...
		return true; //you can not walk through  this tile
	}
}
