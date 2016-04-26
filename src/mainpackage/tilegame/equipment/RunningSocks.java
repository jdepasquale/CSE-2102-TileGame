package mainpackage.tilegame.equipment;

import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;


public class RunningSocks extends Equipment{
	
	private boolean equiped; 
	
	public RunningSocks(Handler handler, String name, BufferedImage equipmentImage) {
		super(handler, name, equipmentImage);
		this.equiped = false;
	}
	
	public void Equip(){
		if(!equiped){
			handler.getWorld().getEntityManager().getPlayer().setSpeed((handler.getWorld().getEntityManager().getPlayer().getSpeed())+ 1 );
		}
		
		else{
			//print box -> already equipped
		}
	}
	
	public void UnEquip(){
		if(equiped){
			handler.getWorld().getEntityManager().getPlayer().setSpeed((handler.getWorld().getEntityManager().getPlayer().getSpeed())*2/3);
		}
		
		else{
			//print box -> not equipped
		}
		
	}
	
	//GETTERS&SETTERS
	
}
