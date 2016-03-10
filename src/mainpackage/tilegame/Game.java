package mainpackage.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import mainpackage.tilegame.display.Display;
import mainpackage.tilegame.gfx.Assets;
import mainpackage.tilegame.gfx.ImageLoader;
import mainpackage.tilegame.gfx.SpriteSheet;
import mainpackage.tilegame.input.KeyManager;
import mainpackage.tilegame.states.ControlsState;
import mainpackage.tilegame.states.GameState;
import mainpackage.tilegame.states.MainMenuState;
import mainpackage.tilegame.states.State;

public class Game implements Runnable {
	
	private Display display;
	public int width;
	public int height;
	public String title;
	
	private boolean running = false;
	
	private BufferStrategy bs; /* a way to tell the computer 
		how to draw to the screen.This is done to prevent "flickering"
		(in old games) caused by writing the game directly to the 
		screen instead of drawing to internal (buffer) screen first */
	
	private Graphics g; // allows you to draw to canvas (paint brush)
	
	
	private Thread thread; // the thread to run the game on
	
	//States
	private State gameState; //declare gameState a state
	private State mainMenuState; 
	private State controlsState;
	
	//Input
	private KeyManager keyManager;
	
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		
	}

	private void init(){ //initializes graphics 
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager); // add key listener to JFrame
		Assets.init();
		
		
		gameState = new GameState(this); //initialize gameState as a GameState
		mainMenuState = new MainMenuState(this);
		controlsState = new ControlsState(this);
		
		State.setState(gameState); // call this anywhere to set state.
	}
	

	
	private void update(){ //(tick) updates game screen
		keyManager.update();
		
		if(State.getState() != null){
			State.getState().update();
		}
	}
	
	private void render(){// draws game screen to the display
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null){
			display.getCanvas().createBufferStrategy(3); // 3 is max
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0,0, width, height); //clears screen between points
		//Draw Here!
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//End Drawing.
		bs.show(); // display new buffer
		g.dispose();// clear old resource
		
	}
	
	public void run() { // needed when runnable is implemented 
		
		//creating consistent runtime for on all computers
		init();
		int fps = 60; // frames per sec
		double timePerUpdate = 1000000000/ fps; /* time measured in 
		nanoseconds this is the max time the program has to run 
		the update and render methods to obtain the desired fps */
		
		long now;
		long timer = 0; //in nanoseconds
		long lastTime = System.nanoTime(); /* current time computer 
		is running at in nanoseconds */
		double delta = 0; /* time program has until the update 
		and render methods have to be called. used to tell when 
		the methods should and should not be called */
		
		//verifying consistent runtime (fps counter)
		int updates = 0; 
		
		while(running){
			now = System.nanoTime(); // current system time in nanoseconds
			//timer += now - lastTime; //time since last run
			delta += (now - lastTime)/timePerUpdate; /* time past since 
			last call divided by the amount of time the maximum 
			amount of time available to call the update and render 
			the methods */
			timer += now - lastTime; //time since last run
			lastTime = now;
			
			if(delta >= 1){
				update();
				render();
				updates ++;
				delta --;
			}
			
			//check if timer has run for one second
			if(timer >= 1000000000){ 
				System.out.println("Updates and Frames: " + updates);
				
				updates = 0;
				timer = 0;
			}
			
		}
		 
		stop();// stops thread
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this); //tells thread to run Game class
		thread.start(); // starts thread (calls run method)
		
	}
	
	public synchronized void stop(){
		if (!running)
			return;
		try {
			thread.join(); // stops thread
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		
		
	}
}
