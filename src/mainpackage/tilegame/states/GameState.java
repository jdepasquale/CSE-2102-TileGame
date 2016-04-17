package mainpackage.tilegame.states;

import java.awt.Graphics;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	//[5:20 #26
	
	public GameState(Handler handler){
		super(handler); // super- calls constructor of class that was extended 
		world = new World (handler, "resources/worlds/world1.txt");
		handler.setWorld(world);
		
		
		
	}
	
	@Override
	public void update() {
		world.update();
	
		
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		
		
		//Tile.tiles[0].render(g, 0, 0);
		//Tile.tiles[1].render(g, 16,16);
	}
	
	
	
}
