package mainpackage.tilegame.entities.statics.item;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.statics.StaticEntity;

public abstract class Item extends StaticEntity{

	private int itemNum;
	
	public Item(Handler handler, float x, float y, int width, int height, int itemNum) {
		super(handler, x, y, width, height);
		//this.itemNum = itemNum;
	}

	public int getItemNum() {
		return itemNum;
	}

}
