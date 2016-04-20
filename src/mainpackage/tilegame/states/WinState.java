package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;

public class WinState extends State{

	public WinState(Handler handler) {
		super(handler);
		
	}

	@Override
	public void update() {
		if(handler.getKeyManager().enter){
			handler.getGame().setGameState(new GameState(handler));
			State.setState(new MainMenuState(handler));
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//change to WinImage
		g.drawImage(Assets.pauseScreenImage, 0, 0, null);
	}

}
