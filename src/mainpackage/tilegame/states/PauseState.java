package mainpackage.tilegame.states;

import java.awt.Graphics;
import mainpackage.tilegame.Handler;
import mainpackage.tilegame.Audio.AudioClips;
import mainpackage.tilegame.graphics.Assets;

public class PauseState extends State{
	
	private boolean pressed;
	
	public PauseState(Handler handler, boolean pressed){
		super(handler);
		this.pressed = pressed;
	}
	
	
	@Override
	public void update() {
	
		
		if(handler.getKeyManager().q ){
			handler.getGame().setGameState(new GameState(handler));
			AudioClips.fg.stop();
			State.setState(new MainMenuState(handler));
		}
		
		if(handler.getKeyManager().enter){
			this.pressed = true;
		}
		if(pressed == true && !handler.getKeyManager().enter){
			this.pressed = false;
			State.setState(handler.getGame().getPreviousState());
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pauseScreenImage, 0, 0, null);
		
	}

}
