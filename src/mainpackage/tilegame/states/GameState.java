package mainpackage.tilegame.states;

import java.awt.Graphics;
import java.awt.Rectangle;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.Audio.AudioClips;
import mainpackage.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	private long lastHpDropTime;
	long timer;
	
	public GameState(Handler handler){
		super(handler); // super- calls constructor of class that was extended 
		world = new World (handler, "resources/worlds/world1.txt");
		handler.setWorld(world);
		lastHpDropTime = System.currentTimeMillis();
		timer = 0;
		play(AudioClips.fg);
	}
	
	
	@Override
	public void update() {
		timer += System.currentTimeMillis() - lastHpDropTime;
		lastHpDropTime = System.currentTimeMillis();
		world.update();
	
		if(handler.getKeyManager().p){
			State.setState(handler.getGame().getPauseState());
		}
	
		if(handler.getKeyManager().s){
			State.setState(handler.getGame().getInventoryState());
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
				if(timer >= 350){
					handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getHealth()-1);
					timer = 0;
				}
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

	}
	
	
	
}
