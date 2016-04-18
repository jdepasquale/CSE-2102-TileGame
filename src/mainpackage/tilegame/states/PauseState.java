package mainpackage.tilegame.states;

import java.awt.Graphics;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;

public class PauseState extends State{

	public PauseState(Handler handler){
		super(handler);
	}
	
	@Override
	public void update() {
	
		if(handler.getKeyManager().q ){
			handler.getGame().setGameState(new GameState(handler));
			State.setState(new MainMenuState(handler));
		}
		if(handler.getKeyManager().c){
			State.setState(handler.getGame().getGameState());
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pauseScreenImage, 0, 0, null);
		
	}

}
