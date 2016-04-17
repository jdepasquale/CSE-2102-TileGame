package mainpackage.tilegame;


public class Launcher { // this starts up the game
	
	public static void main(String[] args){
		Game game = new Game("Project ICE", 480,480);
		game.start();
	}

}
