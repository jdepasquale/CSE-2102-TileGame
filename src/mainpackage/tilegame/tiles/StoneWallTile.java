package mainpackage.tilegame.tiles;

import mainpackage.tilegame.gfx.Assets;

public class StoneWallTile extends Tile {

	public StoneWallTile(int id) {
		super(Assets.stoneWall, id);
	}
	
	@Override
	public boolean isSolid(){ 
		return true; //you can not walk through  this tile
	}

}
