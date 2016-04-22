package mainpackage.tilegame.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

		private BufferedImage sheet; //the actual sprite sheet
		
		public SpriteSheet(BufferedImage sheet){
			this.sheet = sheet;
		}
		
		public BufferedImage crop(int x, int y, int width, int height){
			// (x,y) is location to start crop @ top left of image
			// width - image width, height - image height
			return sheet.getSubimage(x, y, width, height);
		}
}
