package mainpackage.tilegame.entities.Creatures;

import java.awt.Graphics;

import mainpackage.tilegame.Game;
import mainpackage.tilegame.gfx.Assets;

public class Player extends Creature {

	
	public Player(Game game, float x, float y) {
		//sets starting location and creature size 
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

	}

	@Override
	public void update() {
		getInput();
		move();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up){
			yMove = -speed;
		}
		
		if(game.getKeyManager().down){
			yMove = speed;
		}
		
		if(game.getKeyManager().left){
			xMove = -speed;
		}
		
		if(game.getKeyManager().right){
			xMove = speed;
		}
		
	}
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)x, (int)y, width, height, null);
		
	}

}
