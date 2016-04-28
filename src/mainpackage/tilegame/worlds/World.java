package mainpackage.tilegame.worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.EntityManager;
import mainpackage.tilegame.entities.creatures.NPC;
import mainpackage.tilegame.entities.creatures.Player;
import mainpackage.tilegame.entities.creatures.RedBlob;
import mainpackage.tilegame.entities.statics.Chest;
import mainpackage.tilegame.entities.statics.GoldChest;
import mainpackage.tilegame.entities.statics.Iceberg;
import mainpackage.tilegame.entities.statics.Item;
import mainpackage.tilegame.entities.statics.Rock1;
import mainpackage.tilegame.entities.statics.Rock2;
import mainpackage.tilegame.entities.statics.SandMound;
import mainpackage.tilegame.entities.statics.SandStone;
import mainpackage.tilegame.entities.statics.Shrub;
import mainpackage.tilegame.entities.statics.Sign;
import mainpackage.tilegame.entities.statics.Tree;
import mainpackage.tilegame.equipment.Costume;
import mainpackage.tilegame.graphics.Assets;
 
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
	private ArrayList<Chest> chestEntities;
	private ArrayList<Item> itemEntities;
	private ArrayList<NPC> NPCEntities;
	



	public World(Handler handler, String path){ // load world from a file
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 1185, 896, "D"));
		
		
		//NPCs 
		NPCEntities = new ArrayList<NPC>();
		
		NPCEntities.add(new NPC(handler, 29*64, 22*64, 64, 64, Assets.pitchfork,"Howdy there fella,"+"\n"+"my tractor is runnin' low on ENERGY ORE, if you can" + "\n"+ "find me 10, I'd be willin'a give ya a POTATO", 
				"Here's a POTATO for that ENERGY ORE of yours",
				"Thanks for the energy ore"+"\n" +"You take care of that potater now :)",
				"WHHH.... WHAAAT HAVE YOU DONE TO MY"  + "\n" + "PRECIOUS POTATO!?!?!?!",
				new Item(handler, 0, 0, 32, 32, "nothing", 10, Assets.energyOre),
				new Item(handler, 0, 0, 32, 32, "energyOre", 10, Assets.energyOre),
				new Item(handler, 0, 0, 32, 32, "potato", 1, Assets.potato)));
		NPCEntities.add(new NPC(handler, 15*64, 29*64, 64, 64, Assets.buns,"I would cook, but I'm just so terribly ALONE...." ,  
				"Thanks for the LOVE LETTER", "c", "d", new Item(handler, 0, 0, 36, 26, "cutPotato", 10, Assets.cutPotato), 
				new Item(handler, 0, 0, 32, 32, "loveLetter", 1, Assets.letter),
				new Item(handler, 0, 0, 32, 32, "fries", 1, Assets.potato)));
		NPCEntities.add(new NPC(handler, 46*64, 26*64, 64, 64, Assets.megabyte,"like meow, or whatever.",  
				"Hey is that YARN" + "\n" + "He took your YARN",
				"You try to take YARN back." + "\n"+ "Unsucessful but he sliced your POTATO", 
				"Sorry about slicing your POTATO but like meow, or whatever.", 
				new Item(handler, 0, 0, 32, 32, "yarn", 10, Assets.yarn), 
				new Item(handler, 0, 0, 32, 32, "potato", 1, Assets.potato), 
				new Item(handler, 0, 0, 36, 26, "cutPotato", 10, Assets.cutPotato)));
		for(int i = 0; i <NPCEntities.size(); i++){
			entityManager.addEntity(NPCEntities.get(i));
		}
		
		chestEntities = new ArrayList<Chest>();
		chestEntities.add(new Chest(handler, 64*19, 3*64 , new Item(handler, 0, 0, 32, 32,"yarn", 1, Assets.yarn ), null));
		chestEntities.add(new Chest(handler, 64*2, 14*64, null, new Costume(handler, "C3", Assets.V3Costume, Assets.playerV3D, Assets.playerV3DS, Assets.playerV3U, Assets.playerV3US, Assets.playerV3L, Assets.playerV3LS, Assets.playerV3R, Assets.playerV3RS)));
		chestEntities.add(new Chest(handler, 64*31, 12*64, null, new Costume(handler, "C2", Assets.V2Costume, Assets.playerV2D, Assets.playerV2DS, Assets.playerV2U, Assets.playerV2US, Assets.playerV2L, Assets.playerV2LS, Assets.playerV2R, Assets.playerV2RS)));
		chestEntities.add(new Chest(handler, 64*27, 41*64, new Item(handler, 0, 0, 32, 32, "potato", 1, Assets.potato), null));
		chestEntities.add(new Chest(handler, 64*48, 45*64, new Item(handler, 0, 0, 36, 26, "cutPotato", 1, Assets.cutPotato), null));
		chestEntities.add(new GoldChest(handler, 4*64, 44*64, new Item(handler, 0, 0, 32, 32, "energyOre", 1, Assets.energyOre), null));
		for(int i = 0; i <chestEntities.size(); i++){
			entityManager.addEntity(chestEntities.get(i));
		}
		
		signEntities = new ArrayList<Sign>();
		signEntities.add(new Sign(handler, 1080, 870, 0));
		signEntities.add(new Sign(handler, 64*2,64*34, 1));
		signEntities.add(new Sign(handler, 64*12,64*18,2));
		signEntities.add(new Sign(handler, 64*15,64*11, 3));
		signEntities.add(new Sign(handler, 2*64,7*64, 4));
		signEntities.add(new Sign(handler, 64*25,64*10, 5));
		signEntities.add(new Sign(handler, 64*3,44*64, 6));
		signEntities.add(new  Sign(handler, 64*29,64*31, 7));
		signEntities.add(new Sign(handler, 1480, 1075, 8));
		for(int i = 0; i <signEntities.size(); i++){
			entityManager.addEntity(signEntities.get(i));
		}
		
		redBlobEntities = new ArrayList<RedBlob>();
		redBlobEntities.add(new RedBlob(handler, 1500, 920, "D"));
		for(int i = 0; i <redBlobEntities.size(); i++){
			entityManager.addEntity(redBlobEntities.get(i));
		}
		
		
		//canyon
		for(int i = 0; i < 60; i++){
			entityManager.addEntity(new Rock1(handler, i*54-32,0));
		}
		
		for( int i = 0; i < 19; i++){
		entityManager.addEntity(new Rock1(handler, i*64 + 64*2,64*2));
		}
		
		for( int i = 0; i < 15; i++){
			entityManager.addEntity(new Rock1(handler, i*64 + 64*6,64*7));
			}
		for( int  i= 0; i < 6 ; i++){
			entityManager.addEntity(new Rock1(handler,64*2, 64*2+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*9, 64*2+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*15, 64*2+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*20, 64*2+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*2, 64*2+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*6, 64*4+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*12, 64*4+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*20, 64*4+32 + 32*i ));
			entityManager.addEntity(new Rock1(handler,64*4, 64*5+32 + 32*i ));
		}
		entityManager.addEntity(new Rock1(handler,64*3, 64*5));
		
		//dessert
		for(int i = 0; i< 23 ; i++){
			entityManager.addEntity(new Rock2(handler,64*5 +64*i, 64*33));
		}
		for(int i = 0; i< 22 ; i++){
			entityManager.addEntity(new SandStone(handler,64*7 +64*i, 64*43));
		}
		for(int i = 0; i< 2 ; i++){
			entityManager.addEntity(new Rock2(handler,64*(3+i) , 64*34));
			entityManager.addEntity(new SandStone(handler,64*(3+i), 64*40));
			entityManager.addEntity(new SandStone(handler,64*(13+i), 64*41));
			entityManager.addEntity(new SandStone(handler,64*(22+i), 64*39));
			entityManager.addEntity(new SandStone(handler,64*(21+i), 64*37));
			entityManager.addEntity(new SandStone(handler,64*(13+i), 64*41));
			entityManager.addEntity(new SandStone(handler,64*(25+i), 64*35));
			entityManager.addEntity(new SandStone(handler,64*(18+i), 64*39));
			entityManager.addEntity(new SandStone(handler,64*(22+i), 64*35));
			entityManager.addEntity(new SandStone(handler,64*(16+i), 64*41));
			entityManager.addEntity(new SandStone(handler,64*(26+i), 64*38));
			
		}
		for(int i = 0; i< 4 ; i++){	
			entityManager.addEntity(new SandStone(handler,64*6, 64*(34)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*10, 64*(34)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(8), 64*(35)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(8), 64*(42)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(4), 64*(36)+(32*i)));
			entityManager.addEntity(new Rock2(handler,64*(17), 64*(37)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(10), 64*(40)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(14), 64*(39)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(12), 64*(42)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(22), 64*(42)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(29), 64*(47)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(19), 64*(36)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(6), 64*(38)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(12), 64*(38)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(8), 64*(39)+i));
			entityManager.addEntity(new SandStone(handler,64*(5+i), 64*37));
			entityManager.addEntity(new SandStone(handler,64*(12+i), 64*37));
			entityManager.addEntity(new SandStone(handler,64*(16), 64*39));
			entityManager.addEntity(new SandStone(handler,64*(25+i), 64*40));
			entityManager.addEntity(new SandStone(handler,64*(4+i), 64*42));
			entityManager.addEntity(new SandStone(handler,64*(8+i), 64*39));
			entityManager.addEntity(new SandStone(handler,64*(12+i), 64*35));
			entityManager.addEntity(new SandStone(handler,64*(16+i), 64*35));
		}
		for(int i = 0; i< 14 ; i++){	
			entityManager.addEntity(new SandStone(handler,64*(28), 64*(33)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(20), 64*(37)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(28), 64*(40)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(20), 64*(37)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(2), 64*(37)+(32*i)));
			entityManager.addEntity(new SandStone(handler,64*(24), 64*(35)+(32*i)));
		}
		entityManager.addEntity(new SandStone(handler,64*(16), 64*40));
		
		
		//beach
		entityManager.addEntity(new SandMound(handler, 64*5, 64*44));
		entityManager.addEntity(new SandMound(handler, 64*2, 64*45));
		entityManager.addEntity(new SandMound(handler, 64*4, 64*47));
		entityManager.addEntity(new SandMound(handler, 64*7, 64*45));
		
		entityManager.addEntity(new SandMound(handler, 64*11, 64*44));
		entityManager.addEntity(new SandMound(handler, 64*22, 64*44));
		entityManager.addEntity(new SandMound(handler, 64*15, 64*45));
		entityManager.addEntity(new SandMound(handler, 64*24, 64*45));
		
		entityManager.addEntity(new SandMound(handler, 64*13, 64*46));
		entityManager.addEntity(new SandMound(handler, 64*9, 64*47));
		entityManager.addEntity(new SandMound(handler, 64*26, 64*46));
		
		entityManager.addEntity(new SandMound(handler, 64*19, 64*46));
		entityManager.addEntity(new SandMound(handler, 64*23, 64*48));
		
		
		//forest
		entityManager.addEntity(new Tree(handler, 64*26, 4*64));
		entityManager.addEntity(new Tree(handler, 64*27, 5*64));
		entityManager.addEntity(new Tree(handler, 64*24, 4*64));
		entityManager.addEntity(new Tree(handler, 64*26, 6*64));
		entityManager.addEntity(new Tree(handler, 64*27, 8*64));
		entityManager.addEntity(new Tree(handler, 64*26, 4*64));
		entityManager.addEntity(new Tree(handler, 64*24, 4*64));
		entityManager.addEntity(new Tree(handler, 64*27, 6*64));
		entityManager.addEntity(new Tree(handler, 65*28, 8*64));
		entityManager.addEntity(new Tree(handler, 64*27, 10*64));
		entityManager.addEntity(new Tree(handler, 64*26, 12*64));
		entityManager.addEntity(new Tree(handler, 64*27, 14*64));
		entityManager.addEntity(new Tree(handler, 64*28, 13*64 +48));
		entityManager.addEntity(new Tree(handler, 64*29, 14*64));
		entityManager.addEntity(new Tree(handler, 64*30, 13*64 +32));
		entityManager.addEntity(new Tree(handler, 64*31, 14*64));
		
		for(int i = 0; i< 21 ; i++){
			entityManager.addEntity(new Shrub(handler,64*(28+i) ,20*64));
			entityManager.addEntity(new Shrub(handler, 64*34, (i*32)+10*64));
		}
		
		
		
		//tundra
		for(int i = 0; i< 21 ; i++){	
			entityManager.addEntity(new Iceberg(handler,64*(28+i), 64*(30)));
		}

		for(int i = 0; i< 19 ; i++){	
			entityManager.addEntity(new Iceberg(handler,64*(28), 64*(33+i)));
		}

		for(int i = 0; i < 4; i++){
			entityManager.addEntity(new Iceberg(handler,64*(31), 64*(30)+ 32*i));
		}

		entityManager.addEntity(new Iceberg(handler,64*(31), 64*(34)));
		entityManager.addEntity(new Iceberg(handler,64*(32), 64*(34)));
		entityManager.addEntity(new Iceberg(handler,64*(33), 64*(34)));

		for(int i = 0; i < 4; i++){
			entityManager.addEntity(new Iceberg(handler,64*(31), 64*(34)+ 32*i));
		}

		for(int i = 32; i < 36; i++){
			entityManager.addEntity(new Iceberg(handler,64*(i), 64*(34)+32*3));
		}

		for(int i = 3; i > -1; i--){
			entityManager.addEntity(new Iceberg(handler,64*(35), 64*(34)+32*i));
		}

		for(int i = 35; i <44 ; i++){
			entityManager.addEntity(new Iceberg(handler,64*(i), 64*(34)+32*0));
		}
		/* devin
		for(int i = 35; i< 43 ; i++){	
			entityManager.addEntity(new Iceberg(handler,64*(i), 64*(35)));
		}
		
		for(int i = 39; i< 48 ; i++){	
			entityManager.addEntity(new Iceberg(handler,64*(33), 64*(i)));
		}
		
		for(int i = 33; i< 44 ; i++){	
			entityManager.addEntity(new Iceberg(handler,64*(i), 64*(49)));
		}
		
		for(int i = 35; i< 43 ; i++){	
			entityManager.addEntity(new Iceberg(handler,64*(i), 64*(47)));
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		itemEntities = new ArrayList<Item>();
		itemEntities.add(new Item(handler, 64*24+7, 64*45 +6, 48, 24, "goldKey", 1, Assets.goldKey));
		itemEntities.add(new Item(handler, 64*20, 64*22, 32, 32, "energyOre", 1, Assets.energyOre));
		itemEntities.add(new Item(handler, 64*20, 64*26, 32, 32, "energyOre", 1, Assets.energyOre));
		for(int i = 0; i <itemEntities.size(); i++){
			entityManager.addEntity(itemEntities.get(i));
		}
		
	
		entityManager.addEntity(new Tree(handler, 640, 640));
		
		

		
		LoadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);


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
	
	
	
	//GETTERS AND SETTERS
	public ArrayList<Item> getItemEntities() {
		return itemEntities;
	}

	public void setItemEntities(ArrayList<Item> itemEntities) {
		this.itemEntities = itemEntities;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
	
	public ArrayList<Chest> getChestEntities() {
		return chestEntities;
	}
	

	public ArrayList<NPC> getNPCEntities() {
		return NPCEntities;
	}



	public void setNPCEntities(ArrayList<NPC> nPCEntities) {
		NPCEntities = nPCEntities;
	}



	public void setRedBlobEntities(ArrayList<RedBlob> redBlobEntities) {
		this.redBlobEntities = redBlobEntities;
	}



	public void setChestEntities(ArrayList<Chest> chestEntities) {
		this.chestEntities = chestEntities;
	}



	public void update(){
		entityManager.update();
	}


}
