package mainpackage.tilegame.entities.statics;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);		
	}
}
