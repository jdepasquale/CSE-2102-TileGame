package mainpackage.tilegame.worlds;

import java.awt.Graphics;

import mainpackage.tilegame.Game;
import mainpackage.tilegame.tiles.Tile;
import mainpackage.tilegame.utils.Utils;

public class World {
	
	private Game game;
	private int width, height; // map dimensions in in tiles
	private int spawnX, spawnY; // starting position
	private int[][] tiles;// stores all tiles in every position information about tiles 

	public World(Game game, String path){ // load world from a file
		this.game =game;
		LoadWorld(path);
		
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		for(int y = 0; y < height; y++){
			for(int x =0; x < width; x ++){
				getTile(x,y).render(g, x*Tile.TILEWIDTHT, y*Tile.TILEHEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y){ // look up tile id 
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.MetalFloorTile; // default tile
		}
		return t;
	}

	private void LoadWorld(String path) {		
		/* Load world practice
		width = 5;
		height = 5;
		tiles = new int[width][height]; //stores tile ID's in a width by height world
		// make all tiles dirt
		for(int x = 0; x< width; x ++){
			for(int y = 0; y < height; y++){
				tiles[x][y] = 6;
			}
		}
		
		*/
		String file = Utils.LoadFileAsStringPath(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		tiles = new int [width][height];
		for(int y =0; y< height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[x+y*width +4]); // first for elements are already used (above)
						
			}
		}
		
	}
	
	
}
