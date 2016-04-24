package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Assets;

public class SignState extends State{

	private int signNumber;
	
	public SignState(Handler handler, int signNumber) {
		super(handler);
		this.signNumber = signNumber;
		
	}

	@Override
	public void update() {
		if(handler.getKeyManager().p){
			handler.getGame().setPreviousState(this);
			State.setState(handler.getGame().getPauseState());
		}
		
		if(handler.getKeyManager().enter ){	
			State.setState(handler.getGame().getGameState());
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.signs[signNumber], 0, 0, null);
		
	}
	
	//GETTERS&SETTERS
	public int getSignNumber() {
		return signNumber;
	}

	public void setSignNumber(int signNumber) {
		this.signNumber = signNumber;
	}

}
