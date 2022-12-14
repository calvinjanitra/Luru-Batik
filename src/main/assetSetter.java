package main;

import Entity.NPC_Bakul;
import object.obj_chestGold;
import object.obj_chest_brown;
import object.obj_key;

public class assetSetter {

	panelGame gp;
	
	public assetSetter(panelGame gp) {
		this.gp = gp;
	}
	
	
	public void setObject() {
		gp.obj[0] = new obj_key(gp);
		gp.obj[0].worldX = 29*gp.tilesize;
		gp.obj[0].worldY = 48*gp.tilesize;
		
		gp.obj[1] = new obj_key(gp);
		gp.obj[1].worldX = 21*gp.tilesize;
		gp.obj[1].worldY = 13*gp.tilesize;
		
		gp.obj[2] = new obj_chest_brown(gp);
		gp.obj[2].worldX = 28*gp.tilesize;
		gp.obj[2].worldY = 36*gp.tilesize;
		
		gp.obj[3] = new obj_chestGold(gp);
		gp.obj[3].worldX = 42*gp.tilesize;
		gp.obj[3].worldY = 43*gp.tilesize;
		
		gp.obj[4] = new obj_chestGold(gp);
		gp.obj[4].worldX = 27*gp.tilesize;
		gp.obj[4].worldY = 12*gp.tilesize;
		
		
	}
	
	public void setNPC() {
		gp.npc[0] = new NPC_Bakul(gp);
		gp.npc[0].worldX = 30*gp.tilesize;
		gp.npc[0].worldY = 22*gp.tilesize;
	}
}
