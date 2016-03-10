package mainpackage.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//STATIC STUFF
	public static Tile[] tiles = new Tile[256];// array of all tiles
	public static Tile SandTile = new SandTile(0); // static instance of a specific tie
	public static Tile StoneWallTile = new StoneWallTile(1);
	public static Tile MetalFloorTile = new MetalFloorTile(2);
	
	//CLASS
	
	public static final int TILEWIDTHT = 64;
	public static final int TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id; // number given to each individual image. 
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id; 
		
		tiles[id] = this; //sets tiles array at id to static reference 
		
	}

	public void update(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTHT, TILEHEIGHT, null ); // draws image at x, y
		
	}
	
	public boolean isSolid(){ //if a tile is solid you can not walk through it
		return false;
	}
	
	public int getId() {
		return id;
	}
	
}
