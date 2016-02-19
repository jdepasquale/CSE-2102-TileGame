package mainpackage.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import mainpackage.tilegame.display.Display;

public class Game implements Runnable {
	
	private Display display;
	public int width;
	public int y = 0;
	public int height;
	public String title;
	private boolean running = false;
	
	private BufferStrategy bs; /* a way to tell the computer 
		how to draw to the screen.This is done to prevent "flickering"
		(in old games) caused by writing the game directly to the 
		screen instead of drawing to internal (buffer) screen first */
	
	private Graphics g; // allows you to draw to canvas (paint brush)
	
	
	private Thread thread; // the thread to run the game on
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		
	}

	private void init(){ //initializes graphics 
		display = new Display(title, width, height);
	}
	
	private void update(){ //(tick) updates game screen
		
	}
	
	private void render(){// draws game screen to the display
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null){
			display.getCanvas().createBufferStrategy(3); // 3 is max
			return;
		}
		g = bs.getDrawGraphics();
		//Draw Here!
		g.fillRect(0, 0, width, height); //draw rectangle at (0,0)
		
		//End Drawing.
		bs.show(); // display new buffer
		g.dispose();// clear old resource
		
	}
	
	public void run() { // needed when runnable is implemented 
		
		init();
		while(running){
			update();
			render();
		}
		 
		stop();// stops thread
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
