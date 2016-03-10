package mainpackage.tilegame.states;

import java.awt.Graphics;

import mainpackage.tilegame.Game;
import mainpackage.tilegame.gfx.Assets;

public class MainMenuState extends State {
	
	public MainMenuState(Game game){
		super(game);
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, null);
		
	}

}
