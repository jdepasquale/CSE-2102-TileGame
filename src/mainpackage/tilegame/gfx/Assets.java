package mainpackage.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 16; // width of tile in sheet
	private static final int height = 16; // height of tile in sheet
			
			
	public static BufferedImage player;
	public static BufferedImage sand;
	public static BufferedImage stoneWall;
	public static BufferedImage Metalfloor;
	public static BufferedImage background; 

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sss1.png"));
		player = sheet.crop(0, 0, width, height);
		sand = sheet.crop(width, 0, width, height);
		stoneWall = sheet.crop(width*2, 0, width, height);
		Metalfloor = sheet.crop(0, width, width, height);
		background = ImageLoader.loadImage("/textures/abstract.png");

		

	}
}
