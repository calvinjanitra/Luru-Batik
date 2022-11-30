package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.UtilityTool;
import main.panelGame;

public class Entity {
	
	panelGame gp;
	public int worldX, worldY;
	public int speed;
	 
	
	public BufferedImage up1, up2, up3, left1, left2, left3;
	public BufferedImage right1, right2, right3, down1, down2, down3;
	
	public String direction;
	
	public int charcounter = 0;
	public int charnumber = 1;
	
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefX, solidAreaDefY;
	public boolean collisionOn = false;
	public int actionLockCounter = 0;
	String dialogues[] = new String[20];
	int dialogueIndex = 0;
	public Entity(panelGame gp) {
		this.gp = gp;
		
	}
	
	public void setAction() {
		
	}
	
	public void speak() {
		
		if(dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch (gp.player.direction) {
		case "up": 
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "right": 
			direction = "left";
			break;
		case "left":
			direction = "right";
			break;
		}
	}
	public void update() {
		setAction();
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkPlayer(this);
		
		if(collisionOn == false) {
			switch(direction) {
			case "up":
				worldY -= speed;
				break;
			case "down":
				worldY += speed;
				break;
			case "left":
				worldX -= speed;
				break;
			case "right":
				worldX += speed;
				break;
			}
		}
		
		
		charcounter++;
		if(charcounter > 10) {
			if(charnumber == 1) {
				charnumber = 2;
			}
			else if(charnumber == 2) {
				charnumber = 3;
			}
			else if(charnumber == 3) {
				charnumber = 1;
			}
			charcounter = 0;
		}
		
	}
	
	
	public void draw(Graphics2D g2) {

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		BufferedImage image = null;
		
		if(worldX + gp.tilesize > gp.player.worldX - gp.player.screenX && 
				worldX - gp.tilesize < gp.player.worldX + gp.player.screenX && 
				worldY + gp.tilesize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tilesize < gp.player.worldY + gp.player.screenY) {
			
			switch(direction){
			
			case "up":
				if(charnumber == 1) {
					image = up1;	
				}
				if(charnumber == 2) {
					image = up2;
				}
				if(charnumber == 3) {
					image = up3;
				}
				break;
			case "down":
				if(charnumber == 1) {
					image = down1;	
				}
				if(charnumber == 2) {
					image = down2;
				}
				if(charnumber == 3) {
					image = down3;
				}
				break;
			case "left":
				if(charnumber == 1) {
					image = left1;	
				}
				if(charnumber == 2) {
					image = left2;
				}
				if(charnumber == 3) {
					image = left3;
				}
				break;
			case "right":
				if(charnumber == 1) {
					image = right1;	
				}
				if(charnumber == 2) {
					image = right2;
				}
				if(charnumber == 3) {
					image = right3;
				}
				break;
			}
			
			g2.drawImage(image, screenX, screenY, gp.tilesize, gp.tilesize, null);
			
	}
}
		
		
	public BufferedImage setup(String imagePath) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, gp.tilesize, gp.tilesize);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return image;
	}
}