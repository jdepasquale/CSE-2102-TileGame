package mainpackage.tilegame.entities.npc;

import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.statics.Item;

public class Farmer extends NPC{

	public Farmer(Handler handler, float x, float y, int width, int height, BufferedImage npcImage, String a, String b,
			String c, String d, Item itemNeeded, Item interactionItem, Item tradeItem) {
		super(handler, x, y, width, height, npcImage, a, b, c, d, itemNeeded, interactionItem, tradeItem);
		
	}

}
