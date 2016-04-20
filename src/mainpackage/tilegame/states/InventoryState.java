package mainpackage.tilegame.states;

import java.awt.Graphics;
import java.util.ArrayList;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;

public class InventoryState extends State{

	private ArrayList inventory; 
	public InventoryState(Handler handler) {
		super(handler);
		/*
		//get current inventory
		 * first creat inventory in player use arraylist<item numbers>
		 * item numbers tell you which immage to draw
		 * getinventory using handler 
		 *set this.inventor = inventory 
		 */
	}

	@Override
	public void update() {
		if(handler.getKeyManager().s ){
			handler.getGame().setGameState(new GameState(handler));
			State.setState(new MainMenuState(handler));
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//change to InventoryImage
		g.drawImage(Assets.pauseScreenImage, 0, 0, null);
		//display inventory
		//for int i; i< inventory.size(); i++)
		// g.draw(itemNumber
	}

}
