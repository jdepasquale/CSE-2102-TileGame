package mainpackage.tilegame.states;

import java.awt.Graphics;
import mainpackage.tilegame.Game;
import mainpackage.tilegame.entities.Creatures.Player;
import mainpackage.tilegame.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game); // super- calls constructor of class that was extended 
		player = new Player(game, 100,100);
		world = new World (game, "resources/worlds/world1.txt");
	}
	
	@Override
	public void update() {
		world.update();
		player.update();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		//Tile.tiles[0].render(g, 0, 0);
		//Tile.tiles[1].render(g, 16,16);
	}
	
	
	
}
