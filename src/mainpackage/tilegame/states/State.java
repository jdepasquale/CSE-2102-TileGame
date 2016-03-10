package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Game;

// states are game screens such as main menu, settings, how to, and game

public abstract class State {
	
	//Every state must have at least the update and render methods
	protected Game game;
	public State(Game game){
		this.game = game;
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g); // allows state to write to screen
	
	
	//game state manager
	public static State currentState = null;
	// call this to change state at any point
	public static void setState(State state){ 
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}

}
