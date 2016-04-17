package mainpackage.tilegame.tiles;

import mainpackage.tilegame.gfx.Assets;

public class Muddy1Tile extends Tile{

	public Muddy1Tile(int id) {
		super(Assets.muddy1, id);
		
	}
	@Override
	public boolean isSolid(){ 
		return true; 
	}
}
