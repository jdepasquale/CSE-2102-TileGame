package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;

public class GameOverState extends State{

	public GameOverState(Handler handler) {
		super(handler);
		
	}

	@Override
	public void update() {
		if(handler.getKeyManager().enter ){
			handler.getGame().setGameState(new GameState(handler));
			State.setState(new MainMenuState(handler));
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.gameOverImage, 0, 0, null);
	}

}
