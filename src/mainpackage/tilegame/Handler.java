package mainpackage.tilegame;

import mainpackage.tilegame.graphics.GameCamera;
import mainpackage.tilegame.input.KeyManager;
import mainpackage.tilegame.input.MouseManager;
import mainpackage.tilegame.worlds.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game){
		this.game = game;
	}

	//GETTERS&SETTERS
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}


}
