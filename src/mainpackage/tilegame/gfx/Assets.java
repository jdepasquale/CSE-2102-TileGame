package mainpackage.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32; // width of tile in sheet
	private static final int height = 32; // height of tile in sheet
	
	private static final int widthPlayers = 24; // width of tile in sheet
	private static final int heightPlayers = 30; // height of tile in sheet
			
	//V#-Version #, D-Down, U-Up, R-Right,L-Left, S-Standing,
	
	public static BufferedImage[] playerV1D; //animations for walking
	public static BufferedImage[] playerV1DS; 
	public static BufferedImage[] playerV1U;
	public static BufferedImage[] playerV1US;
	public static BufferedImage[] playerV1L;
	public static BufferedImage[] playerV1LS;
	public static BufferedImage[] playerV1R;
	public static BufferedImage[] playerV1RS;
	
	
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
	public static BufferedImage healthStat;
	public static BufferedImage energyOre;
	public static BufferedImage[] enemy1D;
	public static BufferedImage[] enemy1U;
	public static BufferedImage[] enemy1L;
	public static BufferedImage[] enemy1R;
	public static BufferedImage[] fireD;
	public static BufferedImage[] fireU;
	public static BufferedImage[] fireR;
	public static BufferedImage[] fireL;
	public static BufferedImage[] chest;
	public static BufferedImage tree;
	
	public static BufferedImage ice1;
	public static BufferedImage sand;
	public static BufferedImage stoneWall;
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
	public static BufferedImage sign;
	public static BufferedImage shrub;
	
	public static BufferedImage pauseScreenImage;
	public static BufferedImage mainMenuImage;
	
	public static void init(){
		
		pauseScreenImage = ImageLoader.loadImage("/textures/PauseScreen.png");
		mainMenuImage = ImageLoader.loadImage("/textures/MainMenu.png");
		
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
		sand = sheet2.crop(width*9, height, width, height);
		muddy1 = sheet2.crop(width*10, 0, width, height);
		muddy2 = sheet2.crop(width*11, 0, width, height);
		mud = sheet2.crop(width*12, 0, width, height);
		bridgeL = sheet2.crop(width*11, height, width, height);
		bridgeR = sheet2.crop(width*12, height, width, height);
		stoneWall = sheet2.crop(width*14, 0, width, height);
		
	
		//Enemy
		enemy1D = new BufferedImage[5];
		for(int i=0; i<5;i++){
			enemy1D[i] = sheet2.crop(i*16, height*2, 16, 24);
		}
		
		enemy1U = new BufferedImage[5]; 
		for(int i=0; i<5;i++){
			enemy1U[i] = sheet2.crop((i*16)+80, height*2, 16, 24);
		}
		
		enemy1L = new BufferedImage[5];
		for(int i=0; i<5;i++){
			enemy1L[i] = sheet2.crop(i*16, (height*2) + 24, 16, 24);
		}
		
		enemy1R = new BufferedImage[5];
		for(int i=0; i<5;i++){
			enemy1D[i] = sheet2.crop((i*16)+80, (height*2) + 24, 16, 24);
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
		
		healthStat = sheet2.crop(0, 130 + 1, 16, 16);
		
		energyOre = sheet2.crop(16, 130, 16, 16);
		
		chest = new BufferedImage[7];
		for(int i = 0; i<6; i++){
			chest[i] = sheet2.crop(0, 166, 22, 20);
		}
		tree = sheet2.crop(5*width, 0, width*2, height*2);
		
		iceberg = sheet2.crop(width*7, 0, width, height);
		rock1 = sheet2.crop(width*8, 0, width, height);
		rock2 = sheet2.crop(width*9, 0, width, height);
		sign = sheet2.crop(width*13, 0, width, height);
		shrub = sheet2.crop(width*13, height, width, height);
		
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
		
	}
}
