package mainpackage.tilegame.entities.Creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.Audio.AudioClips;
import mainpackage.tilegame.entities.statics.Item;
import mainpackage.tilegame.equipment.Costume;
import mainpackage.tilegame.equipment.Equipment;
import mainpackage.tilegame.graphics.Animation;
import mainpackage.tilegame.graphics.Assets;
import mainpackage.tilegame.states.GameOverState;
import mainpackage.tilegame.states.State;

public class Player extends Creature {

	//Animations
	private Animation downAnim;
	private Animation downStandAnim;
	private Animation upAnim;	
	private Animation upStandAnim;
	private Animation leftAnim;
	private Animation leftStandAnim;
	private Animation rightAnim;
	private Animation rightStandAnim;
	private ArrayList<Item> inventory; 
	private ArrayList<Equipment> equipment;
	private int currentHealth;
	private boolean energyOre;
	private int eq;
	


	private boolean potato;
	

	

	public Player(Handler handler, float x, float y,  String lastAnimDirection) {
		//sets starting location and creature size 
		super(handler, x, y, (Creature.DEFAULT_CREATURE_WIDTH ), Creature.DEFAULT_CREATURE_HEIGHT, lastAnimDirection);
		
		collisionBounds.x = width/4 - 2;
		collisionBounds.y = height/2 -6;
		collisionBounds.width = width*3/4 -8;
		collisionBounds.height = height/2 +4;
		
		interactionBox.x = 0; 
		interactionBox.y = 0; 
		interactionBox.width = width; 
		interactionBox.height = height;
		
		
		this.inventory = new ArrayList<Item>();
		this.equipment = new ArrayList<Equipment>();
		this.eq =0;
		equipment.add(new Costume(handler, "C1", Assets.V1Costume, Assets.playerV1D, Assets.playerV1DS, Assets.playerV1U, Assets.playerV1US, Assets.playerV1L, Assets.playerV1LS, Assets.playerV1R, Assets.playerV1RS));
		//equipment.add(new Costume(handler, "C2", Assets.V2Costume, Assets.playerV2D, Assets.playerV2DS, Assets.playerV2U, Assets.playerV2US, Assets.playerV2L, Assets.playerV2LS, Assets.playerV2R, Assets.playerV2RS));
		//equipment.add(new Costume(handler, "C3", Assets.V3Costume, Assets.playerV3D, Assets.playerV3DS, Assets.playerV3U, Assets.playerV3US, Assets.playerV3L, Assets.playerV3LS, Assets.playerV3R, Assets.playerV3RS));
		//this.inventory.add(new Item(handler, 0, 0, 32, 32, "energyOre", 10, Assets.energyOre));
		/* add equipment
		equipment.add(new RunningSocks(handler, "socks", Assets.beach ));
		*/
		//Animations
		downAnim = new Animation(250, Assets.playerV1D);
		downStandAnim = new Animation(600, Assets.playerV1DS);
		upAnim = new Animation(250, Assets.playerV1U);	
		upStandAnim = new Animation(600, Assets.playerV1US);
		leftAnim = new Animation(100, Assets.playerV1L);
		leftStandAnim = new Animation(600, Assets.playerV1LS);
		rightAnim = new Animation(100, Assets.playerV1R);
		rightStandAnim = new Animation(600, Assets.playerV1RS);
		//this.currentHealth = handler.getWorld().getEntityManager().getPlayer().getHealth() +1;
		
		this.potato = false;
		this.energyOre = false;
		
	}

	@Override
	public void update() {
		//health
		currentHealth = handler.getWorld().getEntityManager().getPlayer().getHealth() +1;
		if(currentHealth  == 1 ){
			AudioClips.traveling.stop();
			AudioClips.gamOver.loop();
			State.setState(new GameOverState(handler, false));
		
		}
		//check items
		for(int i = 0; i < inventory.size(); i++){
			if(inventory.get(i).getName().equals("energyOre")){
				energyOre = true;
			}
			if(inventory.get(i).getName().equals("potato")){
				this.potato = true;
			}
		}
		
		
		//Animations
		downAnim.update();
		downStandAnim.update();
		upAnim.update();
		upStandAnim.update();
		leftAnim.update();
		leftStandAnim.update();
		rightAnim.update();
		rightStandAnim.update();
		
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	
	}
	
	

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
		
	/*//collision rectangle
		g.setColor(Color.red);
		g.fillRect((int)(x + collisionBounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
				collisionBounds.width, collisionBounds.height);
	//player interaction box
		g.setColor(Color.red);
		g.fillRect((int)(x + interactionBox.x - handler.getGameCamera().getxOffset()),
				(int) (y + interactionBox.y - handler.getGameCamera().getyOffset()),
				interactionBox.width, interactionBox.height);
	*/
		g.drawImage(Assets.healthBar[handler.getWorld().getEntityManager().getPlayer().getHealth() ], 375,5, null);
		for(int i = 0; i < inventory.size(); i++){
			
			g.drawImage(inventory.get(i).getItemImage(), 420, 30 + 40*i, handler.getWorld().getEntityManager().getPlayer().getInventory().get(i).getWidth(), handler.getWorld().getEntityManager().getPlayer().getInventory().get(i).getHeight(), null);
			
			if(inventory.get(i).getQuantity() > 1){
				g.setColor(Color.ORANGE);
				g.setFont(new Font("Comic Sans", 1, 22));
				g.drawString("x"+Integer.toString(inventory.get(i).getQuantity()), 453, 50 +40*i);
			}
		
		}
		for(int i = 0; i < equipment.size(); i++){
			g.drawImage(equipment.get(i).getEquipmentImage(), 450, 440 - 20*i, null);
		}
	
	
	
	
	}
	
	//GETTERS&SETTERS
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public int getEq() {
		return eq;
	}

	public void setEq(int eq) {
		this.eq = eq;
	}
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right){
			xMove = speed;
		}	
	}
	
	public boolean getEnergyOre() {
		return energyOre;
	}

	public void setEnergyOre(boolean energyOre) {
		this.energyOre = energyOre;
	}

	public boolean getPotato() {
		return potato;
	}

	public void setPotato(boolean potato) {
		this.potato = potato;
	}

	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(ArrayList<Equipment> equipment) {
		this.equipment = equipment;
	}
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0 ){
			this.setLastAnimDirection("L");
			return leftAnim.getCurrentFrame();
		}
		else if(xMove > 0){
			this.setLastAnimDirection("R");
			return rightAnim.getCurrentFrame();
		}
		else if(yMove < 0){
			this.setLastAnimDirection("U");
			return upAnim.getCurrentFrame();
		} 
		else if(yMove> 0){
			this.setLastAnimDirection("D");
			return downAnim.getCurrentFrame();
		}
		else if(this.getLastAnimDirection() == "U"){
			return upStandAnim.getCurrentFrame();
		}
		else if(this.getLastAnimDirection() == "L"){
			return leftStandAnim.getCurrentFrame();
		}
		else if(this.getLastAnimDirection() == "R"){
			return rightStandAnim.getCurrentFrame();
		}
		else{	
			return downStandAnim.getCurrentFrame();
		}
	}

	public Animation getDownAnim() {
		return downAnim;
	}

	public void setDownAnim(Animation downAnim) {
		this.downAnim = downAnim;
	}

	public Animation getDownStandAnim() {
		return downStandAnim;
	}

	public void setDownStandAnim(Animation downStandAnim) {
		this.downStandAnim = downStandAnim;
	}

	public Animation getUpAnim() {
		return upAnim;
	}

	public void setUpAnim(Animation upAnim) {
		this.upAnim = upAnim;
	}

	public Animation getUpStandAnim() {
		return upStandAnim;
	}

	public void setUpStandAnim(Animation upStandAnim) {
		this.upStandAnim = upStandAnim;
	}

	public Animation getLeftAnim() {
		return leftAnim;
	}

	public void setLeftAnim(Animation leftAnim) {
		this.leftAnim = leftAnim;
	}

	public Animation getLeftStandAnim() {
		return leftStandAnim;
	}

	public void setLeftStandAnim(Animation leftStandAnim) {
		this.leftStandAnim = leftStandAnim;
	}

	public Animation getRightAnim() {
		return rightAnim;
	}

	public void setRightAnim(Animation rightAnim) {
		this.rightAnim = rightAnim;
	}

	public Animation getRightStandAnim() {
		return rightStandAnim;
	}

	public void setRightStandAnim(Animation rightStandAnim) {
		this.rightStandAnim = rightStandAnim;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}


}
