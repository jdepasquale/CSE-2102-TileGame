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
	}


	@Override
	public void update() {
		timer += System.currentTimeMillis() - lastHpDropTime;
		lastHpDropTime = System.currentTimeMillis();
		world.update();

		// Change to Pause Screen 
		if(handler.getKeyManager().p){

			handler.getGame().setGameState(this);
			handler.getGame().setPreviousState(this);
			State.setState(handler.getGame().getPauseState());
		}

		// Check if c is pressed 
		if(handler.getKeyManager().c){
			//check if player is near a sign's interaction box
			if(handler.getWorld().getEntityManager().getPlayer().getLastAnimDirection() == "U"){
				for(int i =0; i < handler.getWorld().getSignEntities().size(); i++ )
					if(checkInteractionBox(handler.getWorld().getSignEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
						handler.getGame().setGameState(this);
						State.setState(new SignState(handler, handler.getWorld().getSignEntities().get(i).getSignNumber()));
					}
				//Check if player is near NPC
				for(int i =0; i < handler.getWorld().getNPCEntities().size(); i++ ){
					if(checkInteractionBox(handler.getWorld().getNPCEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
						handler.getWorld().getNPCEntities().get(i).talk();
					}
				}
			
			
			}
			
			//check if player is near a chest's interaction box
			if(handler.getWorld().getEntityManager().getPlayer().getLastAnimDirection() == "U" || handler.getWorld().getEntityManager().getPlayer().getLastAnimDirection() == "R"){
				for(int i =0; i < handler.getWorld().getChestEntities().size(); i++ ){
					if(checkInteractionBox(handler.getWorld().getChestEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
						if(!handler.getWorld().getChestEntities().get(i).isOpen()){
							handler.getWorld().getChestEntities().get(i).open();
						}
						/*change costume
						 handler.getWorld().getEntityManager().getPlayer().getEquipment().get(0).Equip();
						 
						 */
						//check player has won
						if(playerWon()){
							AudioClips.traveling.stop();
							State.setState( new WinState(handler, false));
						}			
					}			
				}	
			}

		}

		//check if touching item
		if(handler.getWorld().getItemEntities() != null){
			for(int i = 0 ; i < handler.getWorld().getItemEntities().size(); i++){
				if(checkInteractionBox(handler.getWorld().getItemEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
					handler.getWorld().getItemEntities().get(i).setFound(true);
					handler.getWorld().getItemEntities().get(i).add();
					AudioClips.itemGet.play();
					handler.getWorld().getItemEntities().remove(i);
				}
			}
		}


		// Check if being attacked
		for (int i =0; i < handler.getWorld().getRedBlobEntities().size(); i++ ){	
			if(checkInteractionBox(handler.getWorld().getRedBlobEntities().get(i).getInteractionBox(handler.getWorld().getEntityManager().getPlayer().getX(), handler.getWorld().getEntityManager().getPlayer().getY()))){
				if(timer >= 350){
					handler.getWorld().getEntityManager().getPlayer().setHealth(handler.getWorld().getEntityManager().getPlayer().getHealth()-1);
					AudioClips.healthDrop.play();
					timer = 0;
				}
			}
		}






	}

	private boolean playerWon() {
		//if all chests are open
		boolean[] array = new boolean[handler.getWorld().getChestEntities().size()];
		for(int i = 0 ; i < handler.getWorld().getChestEntities().size(); i++){
			array[i] = handler.getWorld().getChestEntities().get(i).isOpen();
		}
		for(boolean open: array){
			if(!open){
				return false;
			}
		}
		return true;

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
