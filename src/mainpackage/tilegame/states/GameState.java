package mainpackage.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	
	public GameState(Handler handler){
		super(handler); // super- calls constructor of class that was extended 
		world = new World (handler, "resources/worlds/world1.txt");
		handler.setWorld(world);
		
		
		
	}
	
	@Override
	public void update() {
		world.update();
	
		if(handler.getKeyManager().p){
			State.setState(handler.getGame().getPauseState());
			/*
			// using sign state class
			SignState temp = new SignState(handler, 7);
			State.setState(temp);
			*/
		}
		
		if(handler.getKeyManager().c && handler.getWorld().getEntityManager().getPlayer().getLastAnimDirection() == "U"){
			//check if player collision box is near a sign's interaction box
			for(int i =0; i < handler.getWorld().getSignEntities().size(); i++ )
				if(checkInteractionBox(handler.getWorld().getSignEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
					
					State.setState(new SignState(handler, handler.getWorld().getSignEntities().get(i).getSignNumber()));
				}
		}
		for (int i =0; i < handler.getWorld().getRedBlobEntities().size(); i++ )	
		if(checkInteractionBox(handler.getWorld().getRedBlobEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
			//check if its been x amount of time
			handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getHealth()-1);
			//set lastHealthdroptime = system time milisec
		}
		
		
	}

	private boolean checkInteractionBox(Rectangle interactionBox) {
		
		if(handler.getWorld().getEntityManager().getPlayer().getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()).intersects(interactionBox)){
			return true;
		}
		return false;
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		/*
		g.setColor(Color.RED);
		g.fillRect(360,20,100 , 20);
		*/
	}
	
	
	
}
