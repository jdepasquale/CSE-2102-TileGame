package mainpackage.tilegame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.Creatures.Player;

public class EntityManager {
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	private Comparator<Entity> renderOrderSorter = new Comparator<Entity>(){

		@Override
		public int compare(Entity a, Entity b) {
			
			if (a.getY() + a.getHeight() < b.getY() +b.getHeight()){
				/*
				 * check if this entity is the health bar - make health bar rendar on top
				if(a == handler.getWorld().getEntityManager().getEntities().get(1)){
					return -1;
				}
				*/
				return -1;
			}
			return 1;
		}	
	};
	
	
	
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void update(){
		for(int i = 0; i < entities.size() ; i++){
			Entity e = entities.get(i);
			e.update();
		}
		entities.sort(renderOrderSorter);
		
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	//GETTERS&SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
}
