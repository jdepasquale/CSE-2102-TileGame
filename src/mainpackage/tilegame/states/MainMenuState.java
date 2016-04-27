package mainpackage.tilegame.states;

import java.awt.Graphics;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.Audio.AudioClips;
import mainpackage.tilegame.graphics.Assets;

public class MainMenuState extends State {
	
	public MainMenuState(Handler handler){
		super(handler);
		play(AudioClips.mainTheme);
	}

	
	
	@Override
	public void update() {
		/*
		//prints the x, y location of mouse to console
		System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY() );
		*/
		//switch to game state if left and right mouse button pressed
		if(handler.getKeyManager().enter){
			AudioClips.mainTheme.stop();
			play(AudioClips.traveling);
			State.setState(new GameState(handler));
			handler.getGame().setPreviousState(handler.getGame().getGameState());
		}
	}


	@Override
	public void render(Graphics g) {
		// renders rectangle where mouse is on screen
		//g.setColor(Color.RED);
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);	
		g.drawImage(Assets.mainMenuImage, 0, 0, null);
	}

}
