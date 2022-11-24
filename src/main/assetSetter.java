package main;

import object.obj_chest_brown;
import object.obj_key;

public class assetSetter {

	panelGame gp;
	
	public assetSetter(panelGame gp) {
		this.gp = gp;
	}
	
	
	public void setObject() {
		gp.obj[0] = new obj_key();
		gp.obj[0].worldX = 39*gp.tilesize;
		gp.obj[0].worldY = 20*gp.tilesize;
		
		gp.obj[1] = new obj_key();
		gp.obj[1].worldX = 39*gp.tilesize;
		gp.obj[1].worldY = 24*gp.tilesize;
		
		gp.obj[2] = new obj_chest_brown();
		gp.obj[2].worldX = 40*gp.tilesize;
		gp.obj[2].worldY = 26*gp.tilesize;
	}
}
