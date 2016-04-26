package mainpackage.tilegame.graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32; // width of tile in sheet
	private static final int height = 32; // height of tile in sheet
	
	private static final int widthPlayers = 24; // width of tile in sheet
	private static final int heightPlayers = 30; // height of tile in sheet
	
	private static final int widthRedBlob = 16; // width of tile in sheet
	private static final int heightRedBlob = 24; // height of tile in sheet
	//V#-Version #, D-Down, U-Up, R-Right,L-Left, S-Standing,
	
	public static BufferedImage[] playerV1D; //animations for walking
	public static BufferedImage[] playerV1DS; 
	public static BufferedImage[] playerV1U;
	public static BufferedImage[] playerV1US;
	public static BufferedImage[] playerV1L;
	public static BufferedImage[] playerV1LS;
	public static BufferedImage[] playerV1R;
	public static BufferedImage[] playerV1RS;
	public static BufferedImage V1Costume;
	
	public static BufferedImage[] playerV2D; //animations for walking
	public static BufferedImage[] playerV2DS; 
	public static BufferedImage[] playerV2U;
	public static BufferedImage[] playerV2US;
	public static BufferedImage[] playerV2L;
	public static BufferedImage[] playerV2LS;
	public static BufferedImage[] playerV2R;
	public static BufferedImage[] playerV2RS;
	public static BufferedImage V2Costume;
	
	public static BufferedImage[] playerV3D; //animations for walking
	public static BufferedImage[] playerV3DS; 
	public static BufferedImage[] playerV3U;
	public static BufferedImage[] playerV3US;
	public static BufferedImage[] playerV3L;
	public static BufferedImage[] playerV3LS;
	public static BufferedImage[] playerV3R;
	public static BufferedImage[] playerV3RS;
	public static BufferedImage V3Costume;
	
	
	public static BufferedImage water2;
	public static BufferedImage brick;
	public static BufferedImage greyTile;
	public static BufferedImage grass;
	public static BufferedImage whiteTile;
	public static BufferedImage dirt;
	public static BufferedImage water;
	public static BufferedImage wood;
	public static BufferedImage[] lightningU;
	public static BufferedImage[] lightningD;
	public static BufferedImage[] lightningR;
	public static BufferedImage[] lightningL;
	public static BufferedImage[] health;
	public static BufferedImage[] healthBar;
	public static BufferedImage energyOre;
	public static BufferedImage[] redBlobD;
	public static BufferedImage[] redBlobU;
	public static BufferedImage[] redBlobL;
	public static BufferedImage[] redBlobR;
	public static BufferedImage[] fireD;
	public static BufferedImage[] fireU;
	public static BufferedImage[] fireR;
	public static BufferedImage[] fireL;
	public static BufferedImage[] chest;
	public static BufferedImage[] goldChest;
	public static BufferedImage tree;

	
	public static BufferedImage ice1;
	public static BufferedImage sand;
	public static BufferedImage beach;
	public static BufferedImage ice2;
	public static BufferedImage snow; 
	public static BufferedImage mud;
	public static BufferedImage muddy1;
	public static BufferedImage muddy2;
	public static BufferedImage bridgeL;
	public static BufferedImage bridgeR;
	public static BufferedImage iceberg;
	public static BufferedImage rock1;
	public static BufferedImage rock2;
	public static BufferedImage sandMound;
	public static BufferedImage sandStone;
	public static BufferedImage sign;
	public static BufferedImage shrub;
	public static BufferedImage greyKey;
	public static BufferedImage goldKey;
	
	public static BufferedImage[] signs; // array of signs (not animation)
	
	public static BufferedImage pauseScreenImage;
	public static BufferedImage mainMenuImage;
	public static BufferedImage gameOverImage;
	public static BufferedImage winImage;
	public static BufferedImage inventoryImage;
	public static BufferedImage newItemImage;
	public static BufferedImage keyNeededImage;
	public static BufferedImage runningSock;
	public static BufferedImage regularSock;
	public static BufferedImage textbox;
	
	public static BufferedImage buns;
	public static BufferedImage pitchfork;
	public static BufferedImage megabyte;
	public static BufferedImage potato;
	public static BufferedImage yarn;
	public static BufferedImage letter;
	public static BufferedImage cutPotato;
	
	
	
	
	public static void init(){
		
		pauseScreenImage = ImageLoader.loadImage("/textures/PauseScreen.png");
		mainMenuImage = ImageLoader.loadImage("/textures/MainMenu.png");
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/signs.png"));
		signs = new BufferedImage[9];// if number of signs changes change array size
		for(int i =0; i<9; i++){
			signs[i] = sheet.crop(i*480, 0, 480, 480);
		}
		gameOverImage = sheet.crop(0,535, 480, 480);
		winImage = sheet.crop(488,535, 480, 480);
		inventoryImage = sheet.crop(972,535, 480, 480);
		newItemImage = sheet.crop(1470,535, 400, 72);
		keyNeededImage = sheet.crop(1469,603, 400, 98);
		textbox = sheet.crop(1469, 700, 400, 99);
		
		
		
		
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/ss2.png"));
		//Tiles
		brick = sheet2.crop(0, 0, width, height);
		greyTile = sheet2.crop(width, 0, width, height);
		grass = sheet2.crop(width*2, 0, width, height);
		whiteTile = sheet2.crop(width*3, 0, width, height);
		dirt = sheet2.crop(0, height, width, height);
		water = sheet2.crop(width, height, width, height);
		water2 = sheet2.crop(width*2, height, width, height);
		wood = sheet2.crop(width*3, height, width, height);
		ice1 = sheet2.crop(width*7, height, width, height);
		ice2 = sheet2.crop(width*8, height, width, height);
		snow = sheet2.crop(width*9, height, width, height);
		sand = sheet2.crop(width*10, height, width, height);
		muddy1 = sheet2.crop(width*10, 0, width, height);
		muddy2 = sheet2.crop(width*11, 0, width, height);
		mud = sheet2.crop(width*12, 0, width, height);
		bridgeL = sheet2.crop(width*11, height, width, height);
		bridgeR = sheet2.crop(width*12, height, width, height);
		beach = sheet2.crop(width*14, 0, width, height);
		
	
		//Enemy
		redBlobD = new BufferedImage[5];
		for(int i=0; i<5;i++){
			redBlobD[i] = sheet2.crop(i*16, height*2, widthRedBlob, heightRedBlob);
		}
		
		redBlobU = new BufferedImage[5]; 
		for(int i=0; i<5;i++){
			redBlobU[i] = sheet2.crop((i*16) + widthRedBlob*5, height*2, widthRedBlob, heightRedBlob);
		}
		
		redBlobL = new BufferedImage[5];
		for(int i=0; i<5;i++){
			redBlobL[i] = sheet2.crop(i*16, (height*2) + heightRedBlob, widthRedBlob, heightRedBlob);
		}
		
		redBlobR = new BufferedImage[5];
		for(int i=0; i<5;i++){
			redBlobR[i] = sheet2.crop((i*16) + widthRedBlob*5, (height*2) + heightRedBlob, widthRedBlob, heightRedBlob);
		}
		
		//Enemy attack animation
		lightningU = new BufferedImage[1];
		lightningU[0]= sheet2.crop(width*4, 0, 16, 20);	
		lightningD = new BufferedImage[1];
		lightningD[0]=sheet2.crop((width*4 + 16), 0, 16, 20);
		lightningR = new BufferedImage[1];
		lightningR[0]=sheet2.crop((width*4), height, 20, 16);
		lightningL = new BufferedImage[1];
		lightningL[0]=sheet2.crop((width*4), height, 20, 16);
		
		//Player attack animation
		fireD = new BufferedImage[17];
		for(int i=0; i<5;i++){
			fireD[i] = sheet2.crop(45, (height*2)+ 57 +(i*9), 9, 9);
		}
		
		for (int i= 5; i < 17; i++){
			fireD[i] = sheet2.crop(i*9, (height*2) + 48, 9, 9);
		}
		fireU = new BufferedImage[17];
		fireU[4] = sheet2.crop(54, (height*2) + 57, 9, 9);
		fireU[3] = sheet2.crop(54, (height*2) + 66, 9, 9);
		fireU[2] = sheet2.crop(54, (height*2) + 75, 9, 9);
		fireU[1] = sheet2.crop(54, (height*2) + 83, 9, 9);
		fireU[0] = sheet2.crop(54, (height*2) + 93, 9, 9);
		for (int i= 5; i < 17; i++){
			fireU[i] =sheet2.crop(i*9, (height*2) + 48, 9, 9);
		}
		
		fireR = new BufferedImage[17];
		for (int i = 0; i < 17; i++){
			fireR[i] =sheet2.crop(i*9, (height*2) + 48, 9, 9);
		}
		
		fireL = new BufferedImage[17];
		fireL[4] = sheet2.crop(0, (height*2) + 57, 9, 9);
		fireL[3] = sheet2.crop(9, (height*2) + 57, 9, 9);
		fireL[2] = sheet2.crop(18, (height*2) + 57, 9, 9);
		fireL[1] = sheet2.crop(27, (height*2) + 57, 9, 9);
		fireL[0] = sheet2.crop(36, (height*2) + 57, 9, 9);
		for (int i= 5; i < 17; i++){
			fireL[i] =sheet2.crop(i*9, (height*2) + 48, 9, 9);
		}
		
		//Entities
		health = new BufferedImage[4];
		for(int i=0; i<3;i++){
			health[i] = sheet2.crop(0, 130 + i, 16, 16);
		}
		
		healthBar = new BufferedImage[5];
		for(int i = 0; i < 5; i++){
			healthBar[i] = sheet2.crop(width*7, height*2 +80 - 20*i, 100, 20);
		}
		
		
		energyOre = sheet2.crop(16, 130, 16, 16);
		
		greyKey = sheet2.crop(16, 145, 16, 8);
		goldKey = sheet2.crop(16, 154, 16, 8);
		runningSock = sheet2.crop(64, 122, 16, 16);
		regularSock = sheet2.crop(16, 138, 16, 16);
	
		chest = new BufferedImage[7];
		for(int i = 0; i<7; i++){
			chest[i] = sheet2.crop(i*22, 188, 22, 20);
		}
		
		
		goldChest = new BufferedImage[7];
		for(int i = 0; i<7; i++){
			goldChest[i] = sheet2.crop(i*22, 166, 22, 20);
		}
		
		
		tree = sheet2.crop(5*width, 0, width*2, height*2);
		
		iceberg = sheet2.crop(width*7, 0, width, height);
		rock1 = sheet2.crop(width*8, 0, width, height);
		rock2 = sheet2.crop(width*9, 0, width, height);
		sign = sheet2.crop(width*13+3, 3, 26, 24);
		shrub = sheet2.crop(width*13, height, width, height);
		sandMound = sheet2.crop(width*14, height, width, height);
		sandStone = sheet2.crop(width*14, height, width, height - 5);
		
		
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/signs.png"));
		buns = sheet3.crop(0, 0, width, height);
		pitchfork = sheet3.crop(width, 0, width, height);
		megabyte = sheet3.crop(width*2, 0, width, height);
		potato = sheet3.crop(width*3, 0, width, height);
		yarn = sheet3.crop(width*4, 0, width, height);
		letter = sheet3.crop(width*5, 0, width, height);
		cutPotato = sheet3.crop(94, height, 18 , height);
		
		
		
		
		
		
		
		
		
		//Player		
		SpriteSheet players = new SpriteSheet(ImageLoader.loadImage("/textures/players.png"));
		playerV1D = new BufferedImage[2];
		playerV1D[0] = players.crop(widthPlayers, 0, widthPlayers, heightPlayers);
		playerV1D[1] = players.crop(widthPlayers*2, 0, widthPlayers, heightPlayers);
		
		playerV1DS = new BufferedImage[1];	
		playerV1DS[0] = players.crop(0, 0, widthPlayers, heightPlayers);
		
		playerV1U = new BufferedImage[2];
		playerV1U[0] = players.crop(widthPlayers, heightPlayers, widthPlayers, heightPlayers);
		playerV1U[1]= players.crop(widthPlayers*2, heightPlayers, widthPlayers, heightPlayers);
		
		playerV1US = new BufferedImage[1];	
		playerV1US[0] = players.crop(0, heightPlayers, widthPlayers, heightPlayers);
		
		playerV1L = new BufferedImage[2];
		playerV1L[1] = players.crop(widthPlayers*4, 0, widthPlayers, heightPlayers);
		playerV1L[0] = players.crop(widthPlayers*5, 0, widthPlayers, heightPlayers);
		
		playerV1LS = new BufferedImage[1];	
		playerV1LS[0]= players.crop(widthPlayers*3, 0, widthPlayers, heightPlayers); 
		
		playerV1R = new BufferedImage[2];		
		playerV1R[0] = players.crop(widthPlayers*4, heightPlayers, widthPlayers, heightPlayers);
		playerV1R[1] = players.crop(widthPlayers*5, heightPlayers, widthPlayers, heightPlayers);

		playerV1RS = new BufferedImage[1];	
		playerV1RS[0] = players.crop(widthPlayers*3, heightPlayers, widthPlayers, heightPlayers);
		
		V1Costume = players.crop(154, 17, 16, 14 );
		
		
		playerV2D = new BufferedImage[2];
		playerV2D[0] = players.crop(widthPlayers, heightPlayers*2, widthPlayers, heightPlayers);
		playerV2D[1] = players.crop(widthPlayers*2, heightPlayers*2, widthPlayers, heightPlayers);
		
		playerV2DS = new BufferedImage[1];	
		playerV2DS[0] = players.crop(0, heightPlayers*2, widthPlayers, heightPlayers);
		
		playerV2U = new BufferedImage[2];
		playerV2U[0] = players.crop(widthPlayers, heightPlayers*3, widthPlayers, heightPlayers);
		playerV2U[1]= players.crop(widthPlayers*2, heightPlayers*3, widthPlayers, heightPlayers);
		
		playerV2US = new BufferedImage[1];	
		playerV2US[0] = players.crop(0, heightPlayers*3, widthPlayers, heightPlayers);
		
		playerV2L = new BufferedImage[2];
		playerV2L[1] = players.crop(widthPlayers*4, heightPlayers*2, widthPlayers, heightPlayers);
		playerV2L[0] = players.crop(widthPlayers*5, heightPlayers*2, widthPlayers, heightPlayers);
	
		playerV2LS = new BufferedImage[1];	
		playerV2LS[0]= players.crop(widthPlayers*3, heightPlayers*2, widthPlayers, heightPlayers); 
		
		playerV2R = new BufferedImage[2];		
		playerV2R[0] = players.crop(widthPlayers*4, heightPlayers*3, widthPlayers, heightPlayers);
		playerV2R[1] = players.crop(widthPlayers*5, heightPlayers*3, widthPlayers, heightPlayers);

		playerV2RS = new BufferedImage[1];	
		playerV2RS[0] = players.crop(widthPlayers*3, heightPlayers*3, widthPlayers, heightPlayers);
		
		V2Costume = players.crop(152, 107, 16, 14 );
		
		playerV3D = new BufferedImage[2];
		playerV3D[0] = players.crop(widthPlayers, heightPlayers*4, widthPlayers, heightPlayers);
		playerV3D[1] = players.crop(widthPlayers*2, heightPlayers*4, widthPlayers, heightPlayers);
		
		playerV3DS = new BufferedImage[1];	
		playerV3DS[0] = players.crop(0, heightPlayers*4, widthPlayers, heightPlayers);
		
		playerV3U = new BufferedImage[2];
		playerV3U[0] = players.crop(widthPlayers, heightPlayers*5, widthPlayers, heightPlayers);
		playerV3U[1]= players.crop(widthPlayers*2, heightPlayers*5, widthPlayers, heightPlayers);
		
		playerV3US = new BufferedImage[1];	
		playerV3US[0] = players.crop(0, heightPlayers*5, widthPlayers, heightPlayers);
		
		playerV3L = new BufferedImage[2];
		playerV3L[1] = players.crop(widthPlayers*4, heightPlayers*4, widthPlayers, heightPlayers);
		playerV3L[0] = players.crop(widthPlayers*5, heightPlayers*4, widthPlayers, heightPlayers);
		
		playerV3LS = new BufferedImage[1];	
		playerV3LS[0]= players.crop(widthPlayers*3, heightPlayers*4, widthPlayers, heightPlayers); 
		
		playerV3R = new BufferedImage[2];		
		playerV3R[0] = players.crop(widthPlayers*4, heightPlayers*5, widthPlayers, heightPlayers);
		playerV3R[1] = players.crop(widthPlayers*5, heightPlayers*5, widthPlayers, heightPlayers);

		playerV3RS = new BufferedImage[1];	
		playerV3RS[0] = players.crop(widthPlayers*3, heightPlayers*5, widthPlayers, heightPlayers);
		
		V3Costume = players.crop(154, 168, 16, 14 );
	}
}
