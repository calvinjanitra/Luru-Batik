package main;

import javax.sql.rowset.CachedRowSet;

import Entity.Entity;

public class CollisionChecker {

	panelGame gp;
	public CollisionChecker(panelGame gp) {
		this.gp = gp;
	}
	
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tilesize;
		int entityRightCol = entityRightWorldX/gp.tilesize;
		int entityTopRow = entityTopWorldY/gp.tilesize;
		int entityBottomRow = entityBottomWorldY/gp.tilesize;
		
		int tilenum1,tilenum2;
		
	
		switch (entity.direction) {
		
		case "up" :
			entityTopRow = (entityTopWorldY - entity.speed) /gp.tilesize;
			tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "down":
			
			entityBottomRow = (entityBottomWorldY + entity.speed)/ gp.tilesize;
			tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tilesize;
			tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tilenum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed) / gp.tilesize;
			tilenum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tilenum1].collision == true || gp.tileM.tile[tilenum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		}
	
		
	}
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		
		for(int i = 0; i < gp.obj.length; i++) {
			
			if(gp.obj[i] != null) {
				//get entity solid area position 
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				// get object solid area position 
				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
				
				switch (entity.direction) {
				case "up" :
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
					if(player == true) {
						index = i;
						}
					}
					break;
					
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
					if(player == true) {
						index = i;
						}
					}
					break;
					
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
					if(player == true) {
						index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
					if(player == true) {
						index = i;
						}
					}
					break;
				}
				entity.solidArea.x = entity.solidAreaDefX;
				entity.solidArea.y = entity.solidAreaDefY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefY;
			}
			
		}
		return index;
	}
	
	
}
