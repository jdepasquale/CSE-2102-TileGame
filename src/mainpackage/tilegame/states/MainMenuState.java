package mainpackage.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;

public class MainMenuState extends State {
	
	public MainMenuState(Handler handler){
		super(handler);
	}

	@Override
	public void update() {
		/*
		//prints the x, y location of mouse to console
		System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY() );
		*/
		//switch to game state if left and right mouse button pressed
		if(handler.getKeyManager().enter || handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()){
			State.setState(handler.getGame().getGameState());
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
