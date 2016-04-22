package mainpackage.tilegame.tiles;

import mainpackage.tilegame.graphics.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water, id);
		
		
	}
	@Override
	public boolean isSolid(){ 
		return true; //you can not walk through  this tile
	}
}
