package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;

public class GameOverState extends State{

	private boolean pressed;

	
	public GameOverState(Handler handler, boolean pressed) {
		super(handler);
		this.pressed = pressed;
		
	}
	

	@Override
	public void update() {
		if(handler.getKeyManager().enter){
			this.pressed = true;
		}
		if(pressed == true && !handler.getKeyManager().enter){
			this.pressed = false;
			handler.getGame().setGameState(null);
			State.setState(new MainMenuState(handler));
			handler.getGame().setPreviousState(handler.getGame().getMainMenuState());
		}
			
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameOverImage, 0, 0, null);
	}

	
}
