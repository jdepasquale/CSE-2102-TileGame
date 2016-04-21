package mainpackage.tilegame.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.EntityManager;
import mainpackage.tilegame.entities.Creatures.Player;
import mainpackage.tilegame.entities.Creatures.RedBlob;
import mainpackage.tilegame.entities.statics.HealthBar;
import mainpackage.tilegame.entities.statics.Iceberg;
import mainpackage.tilegame.entities.statics.Rock1;
import mainpackage.tilegame.entities.statics.Rock2;
import mainpackage.tilegame.entities.statics.SandMound;
import mainpackage.tilegame.entities.statics.SandStone;
import mainpackage.tilegame.entities.statics.Shrub;
import mainpackage.tilegame.entities.statics.Sign;
import mainpackage.tilegame.entities.statics.Tree;
import mainpackage.tilegame.tiles.Tile;
import mainpackage.tilegame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height; // map dimensions in in tiles
	private int spawnX, spawnY; // starting position
	private int[][] tiles;// stores all tiles in every position information about tiles 

	//Entities
	private EntityManager entityManager;
	private ArrayList<Sign> signEntities;
	private ArrayList<RedBlob> redBlobEntities;
	//private ArrayList<Chest> chestEntities;
	
	
	public World(Handler handler, String path){ // load world from a file
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 1216, 896, "D"));
		entityManager.addEntity(new Tree(handler, 640, 640));
		//entityManager.addEntity(new Rock1(handler, 100,160));
		//entityManager.addEntity(new Rock2(handler, 100,500));
		//entityManager.addEntity(new Iceberg(handler, 100,260));
		//entityManager.addEntity(new Shrub(handler, 100,300));
		//entityManager.addEntity(new Shrub(handler, 151,300));
		//entityManager.addEntity(new Shrub(handler, 100,332));
		
		signEntities = new ArrayList<Sign>();
		signEntities.add(new Sign(handler, 100,364, 0));
		
		
		for(int i = 0; i <signEntities.size(); i++){
			entityManager.addEntity(signEntities.get(i));
		}
		entityManager.addEntity(new SandMound(handler, 1216,2122));
		entityManager.addEntity(new SandStone(handler, 1216,2022));
		entityManager.addEntity(new SandStone(handler, 1184,1990));
		
		
		for(int i = 0; i < 60; i++){
			entityManager.addEntity(new Rock1(handler, i*54-32,0));
		}
		
		
		
		redBlobEntities = new ArrayList<RedBlob>();
		redBlobEntities.add(new RedBlob(handler, 1300, 920, "D"));
		for(int i = 0; i <redBlobEntities.size(); i++){
			entityManager.addEntity(redBlobEntities.get(i));
		}
		
		
		
		entityManager.addEntity(new HealthBar(handler, 0,0));
		LoadWorld(path);
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public ArrayList<Sign> getSignEntities() {
		return signEntities;
	}
	public ArrayList<RedBlob> getRedBlobEntities() {
		return redBlobEntities;
	}

	public void update(){
		entityManager.update();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0,  handler.getGameCamera().getxOffset()/Tile.TILEWIDTH); // left most rendered tile;
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1); // right most rendered tile;
		int yStart = (int) Math.max(0,  handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEWIDTH + 1);
		
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x ++){
				getTile(x,y).render(g, (int)( x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int)((y*Tile.TILEHEIGHT)- handler.getGameCamera().getyOffset()));
			}
		}
		
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){ // look up tile id 
		//prevent crash if player is not in map
		if(x < 0 || y <0 || x >= width || y >= height){
			return Tile.GrassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.GrassTile; // default tile
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	
	
}
