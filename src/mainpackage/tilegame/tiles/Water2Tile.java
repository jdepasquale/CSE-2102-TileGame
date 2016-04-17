package mainpackage.tilegame.tiles;

import mainpackage.tilegame.gfx.Assets;

public class Water2Tile extends Tile {

	public Water2Tile(int id) {
		super(Assets.water2, id);
		
		
	}
	@Override
	public boolean isSolid(){ 
		return true; //you can not walk through  this tile
	}
}
