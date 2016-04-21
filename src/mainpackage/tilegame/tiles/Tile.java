package mainpackage.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//STATIC STUFF
	public static Tile[] tiles = new Tile[256];// array of all tiles
	// static instance of a specific tile
	public static Tile BrickTile = new BrickTile(0);
	public static Tile GreyTileTile = new GreyTileTile(1);
	public static Tile GrassTile = new GrassTile(2);
	public static Tile WhiteTileTile = new WhiteTileTile(3);
	public static Tile Muddy1Tile = new Muddy1Tile(4);
	public static Tile Muddy2Tile = new Muddy2Tile(5);
	public static Tile MudTile = new MudTile(6);
	public static Tile BeachTile = new BeachTile(7);
	public static Tile DirtTile = new DirtTile(8);
	public static Tile WaterTile = new WaterTile(9);
	public static Tile Water2Tile = new Water2Tile(10);
	public static Tile WoodTile = new WoodTile(11);
	public static Tile Ice1Tile = new Ice1Tile(12);
	public static Tile Ice2Tile = new Ice1Tile(13);
	public static Tile SnowTile = new SnowTile(14);
	public static Tile SandTile = new SandTile(15);
	public static Tile BridgeLTile = new BridgeLTile(16);
	public static Tile BridgeRTile = new BridgeRTile(17);
	
	//CLASS
	
	public static final int TILEWIDTH = 64;
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
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null ); // draws image at x, y
		
	}
	
	public boolean isSolid(){ //if a tile is solid you can not walk through it
		return false;
	}
	
	public int getId() {
		return id;
	}
	
}
