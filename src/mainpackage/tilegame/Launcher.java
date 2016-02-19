package mainpackage.tilegame;


public class Launcher { // this starts up the game
	
	public static void main(String[] args){
		Game game = new Game("Game Title", 600,500);
		game.start();
	}

}
