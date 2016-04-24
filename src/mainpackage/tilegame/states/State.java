package mainpackage.tilegame.states;

import java.applet.AudioClip;
import java.awt.Graphics;
import mainpackage.tilegame.Handler;

// states are game screens such as main menu, settings, how to, and game

public abstract class State {
	
	//game state manager
	private static State currentState = null;
	
	//CLASS
	//Every state must have at least the update and render methods
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public void play(AudioClip ac){
		ac.loop();
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g); // allows state to write to screen

	//GETTERS&SETTERS
	// call this to change state at any point
	public static void setState(State state){ 
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}

}
