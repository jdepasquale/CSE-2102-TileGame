package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.Audio.AudioClips;
import mainpackage.tilegame.graphics.Assets;

public class WinState extends State{

	private boolean pressed;
	
	public WinState(Handler handler, boolean pressed) {
		super(handler);
		this.pressed = pressed;
		
	}

	@Override
	public void update() {
		if(handler.getKeyManager().enter){
			this.pressed = true;
		}
		if(pressed == true && !handler.getKeyManager().enter){
			handler.getGame().setGameState(null);
			this.pressed = false;
			AudioClips.mainTheme.loop();          ;
			State.setState(handler.getGame().getMainMenuState());
			handler.getGame().setPreviousState(handler.getGame().getMainMenuState());
			
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.winImage, 0, 0, null);
	}

}
