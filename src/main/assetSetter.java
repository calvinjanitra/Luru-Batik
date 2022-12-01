package main;

import Entity.NPC_Bakul;
import object.obj_chest_brown;
import object.obj_key;

public class assetSetter {

	panelGame gp;
	
	public assetSetter(panelGame gp) {
		this.gp = gp;
	}
	
	
	public void setObject() {
		gp.obj[0] = new obj_key(gp);
		gp.obj[0].worldX = 38*gp.tilesize;
		gp.obj[0].worldY = 20*gp.tilesize;
		
		gp.obj[1] = new obj_key(gp);
		gp.obj[1].worldX = 38*gp.tilesize;
		gp.obj[1].worldY = 24*gp.tilesize;
		
		gp.obj[2] = new obj_chest_brown(gp);
		gp.obj[2].worldX = 38*gp.tilesize;
		gp.obj[2].worldY = 26*gp.tilesize;
	}
	
	public void setNPC() {
		gp.npc[0] = new NPC_Bakul(gp);
		gp.npc[0].worldX = 37*gp.tilesize;
		gp.npc[0].worldY = 26*gp.tilesize;
	}
}
