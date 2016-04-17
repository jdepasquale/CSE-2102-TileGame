package mainpackage.tilegame.tiles;


import mainpackage.tilegame.gfx.Assets;

public class Muddy2Tile extends Tile{

	public Muddy2Tile( int id) {
		super(Assets.muddy2, id);
		
	}
	@Override
	public boolean isSolid(){ 
		return true; 
	}
}
