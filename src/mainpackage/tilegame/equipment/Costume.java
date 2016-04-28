package mainpackage.tilegame.equipment;

import java.awt.image.BufferedImage;

import mainpackage.tilegame.Handler;
import mainpackage.tilegame.graphics.Animation;

public class Costume extends Equipment {
	
	private BufferedImage[] D;
	private BufferedImage[] Ds;
	private BufferedImage[] U;
	private BufferedImage[] Us;
	private BufferedImage[] L;
	private BufferedImage[] Ls;
	private BufferedImage[] R;
	private BufferedImage[] Rs;
	private BufferedImage equipIm;
	
	public Costume(Handler handler, String name, BufferedImage equipmentImage, BufferedImage[] down, BufferedImage[] downSt,BufferedImage[] up, BufferedImage[] upSt, BufferedImage[] left, BufferedImage[] leftSt,BufferedImage[] right, BufferedImage[] rightSt) {
		super(handler, name, equipmentImage);
		this.D = down;
		this.Ds = downSt;
		this.U = up;
		this.Us = upSt;
		this.L = left;
		this.Ls = leftSt;
		this.R = right;
		this.Rs = rightSt;
		this.equipIm = equipmentImage;
		
	}
	
	

	public void Equip(){
		
		handler.getWorld().getEntityManager().getPlayer().setDownAnim(new Animation(250, D));
		handler.getWorld().getEntityManager().getPlayer().setDownStandAnim(new Animation(600, Ds));
		handler.getWorld().getEntityManager().getPlayer().setUpAnim(new Animation(250, U));	
		handler.getWorld().getEntityManager().getPlayer().setUpStandAnim(new Animation(600, Us));
		handler.getWorld().getEntityManager().getPlayer().setLeftAnim(new Animation(100, L));
		handler.getWorld().getEntityManager().getPlayer().setLeftStandAnim(new Animation(600, Ls));
		handler.getWorld().getEntityManager().getPlayer().setRightAnim(new Animation(100, R));
		handler.getWorld().getEntityManager().getPlayer().setRightStandAnim(new Animation(600, Rs));
	}
	
	//GETTERS&SETTERS
	public BufferedImage getEquipIm() {
		return equipIm;
	}
}
