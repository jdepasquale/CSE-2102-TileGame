package mainpackage.tilegame.gfx;

public class GameCamera {
	
	private float xOffset; // an offset of +ten pixels would move a drawing ten to the left
	private float yOffset;
	
	public GameCamera (float xOffset, float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void move(float xAmt, float yAmt){
		//video 5:00
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
