package mainpackage.tilegame.states;

import java.awt.Graphics;
import java.util.ArrayList;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.statics.Item;
import mainpackage.tilegame.graphics.Assets;

public class InventoryState extends State{

	private ArrayList<Item> stuff; 
	public InventoryState(Handler handler) {
		super(handler);
		
		//get current inventory
		
		/*
		 * first creat inventory in player use arraylist<item numbers>
		 * item numbers tell you which immage to draw
		 * getinventory using handler 
		 *set this.inventor = inventory 
		 */
	}
/*
	public ArrayList<Entity> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Entity> inventory) {
		this.inventory = inventory;
	}
	*/

	@Override
	public void update() {
		if(handler.getKeyManager().enter ){
			State.setState(handler.getGame().getGameState());
		}
		
		if(handler.getKeyManager().p){
			handler.getGame().setPreviousState(this);
			State.setState(handler.getGame().getPauseState());
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.inventoryImage, 0, 0, null);
		//display inventory
		//for int i; i< inventory.size(); i++)
		// g.draw(itemNumber
	}

}
