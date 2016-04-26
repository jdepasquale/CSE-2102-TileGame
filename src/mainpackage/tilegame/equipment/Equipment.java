package mainpackage.tilegame.equipment;


import java.awt.image.BufferedImage;
import mainpackage.tilegame.Handler;

public class Equipment{

	protected Handler handler;
	private String name;
	private BufferedImage equipmentImage;
	
	public Equipment(Handler handler, String name, BufferedImage equipmentImage) {
		this.name = name;
		this.equipmentImage = equipmentImage;
		this.handler = handler;
	
	}
	public void Equip(){
	
	}
	
	//GETTERS&SETTERS
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BufferedImage getEquipmentImage() {
		return equipmentImage;
	}


	public void setEquipmentImage(BufferedImage itemImage) {
		this.equipmentImage = itemImage;
	}



}
