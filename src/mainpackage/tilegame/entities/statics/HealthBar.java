package mainpackage.tilegame.entities.statics;

import java.awt.Graphics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.gfx.Assets;
import mainpackage.tilegame.states.State;
import mainpackage.tilegame.tiles.Tile;

public class HealthBar extends StaticEntity{
	
	private int currentHealth;
	public HealthBar(Handler handler, float x, float y){
		super(handler, x, y, Tile.TILEWIDTH, (Tile.TILEHEIGHT));
		
		collisionBounds.x = 0;
		collisionBounds.y = 0;
		collisionBounds.width = 0;
		collisionBounds.height = 0 ;
	
	}

	
	@Override
	public void update() {
		currentHealth = handler.getWorld().getEntityManager().getPlayer().getHealth();
		if(currentHealth <= 1 ){
			State.setState(handler.getGame().getGameOverState());
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.healthBar[handler.getWorld().getEntityManager().getPlayer().getHealth()-1], 375,5, null);
		//handler.getWorld().getEntityManager().getPlayer().getHealth()-1
	}
}