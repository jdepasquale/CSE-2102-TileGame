package mainpackage.tilegame.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.entities.statics.Item;
import mainpackage.tilegame.graphics.Assets;

public class NPC extends Entity{

	private int dialogueNumber; // this number tells what string[] each NPC can use
	private String currentString;
	private String a;
	private String b;
	private String c;
	private BufferedImage npcImage;
	private boolean talking;
	private boolean had;
	private boolean closed;
	private Item itemNeeded;
	private Item toGive;
	
	
	public NPC(Handler handler, float x, float y, int width, int height, BufferedImage npcImage, String a, String b, String c, Item itemNeeded, Item toGive) {
		super(handler, x, y, width, height);
		collisionBounds.x = width/2; 
		collisionBounds.y = height/4; 
		collisionBounds.width = width*3/8; 
		collisionBounds.height = height/4;
		
		interactionBox.x = -width/2; 
		interactionBox.y = -height/2; 
		interactionBox.width = width; 
		interactionBox.height = height*2;
		
		this.dialogueNumber = 0;
		this.npcImage = npcImage;
		this.a = a;
		this.b = b;
		this.c = c;
		this.itemNeeded = itemNeeded;
		this.had = false;
		this.toGive = toGive;
		this.currentString = a;
		this.talking = false;
		this.closed = true;
	}


	@Override
	public void update() {
		if(handler.getKeyManager().enter){
			closed = true;
		}
		
		
		
		
	}
	
	public void talk(){
		talking = true;
		closed = false;
		//check if has item
		
		currentString = a;
		
		/*
		if(!handler.getWorld().getEntityManager().getPlayer().getPotato()){
			currentString = c;
		}
		else if(handler.getWorld().getEntityManager().getPlayer().getEnergyOre()){
			currentString = b;
			exchange();
		}
		
		else {
			
		}
		*/
	}
	
	public void exchange(){
		for(int i = 0; i <handler.getWorld().getEntityManager().getPlayer().getInventory().size() ; i++){
			if(handler.getWorld().getEntityManager().getPlayer().getInventory().get(i) == itemNeeded){
				handler.getWorld().getEntityManager().getPlayer().getInventory().remove(i);
				handler.getWorld().getEntityManager().getPlayer().getInventory().add(toGive);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(npcImage,(int) (x - handler.getGameCamera().getxOffset()),(int)( y - handler.getGameCamera().getyOffset()), width, height, null);
		if(talking && !closed){
			g.drawImage(Assets.textbox, 42,375, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans", 1, 15));
			int lineNum = 0;
			for(String line : currentString.split("\n")){
				g.drawString(line, 50, 400 + g.getFontMetrics().getHeight()*lineNum);
				lineNum = lineNum + 1;
			}
			g.setColor(Color.RED);
			g.drawString("Press Enter or 4", 300, 460);
			
			
		}
		else{
			talking = false;
			
		}
		
		
		
	}
	
	//GETTERS&SETTERS
	public int getDialogueNumber() {
		return dialogueNumber;
	}

	public void setDialogueNumber(int dialogueNumber) {
		this.dialogueNumber = dialogueNumber;
	}

	public boolean isTalking() {
		return talking;
	}

	public void setTalking(boolean talking) {
		this.talking = talking;
	}

}
