package mainpackage.tilegame.states;

import java.awt.Graphics;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	
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
	}
	
	
	
}
