package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InterruptedIOException;

import javax.imageio.ImageIO;

import main.KeyInputHandler;
import main.UtilityTool;
import main.panelGame;
import object.obj_chest_brown;

public class Player extends Entity{

	public KeyInputHandler KeyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;

	public int solidAreaDefaultX;

	public int solidAreaDefaultY;
	
	public Player(panelGame gp, KeyInputHandler keyH) {
		
		super(gp);

		this.KeyH = keyH;
		
		screenX = gp.panjangScreen/2 - (gp.tilesize/2);
		screenY = gp.TinggiScreen/2 - (gp.tilesize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefX = solidArea.x;
		solidAreaDefY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValue();
		getPlayerImage();
	}

	
	public void setDefaultValue() {
		worldX = gp.tilesize * 24;
		worldY = gp.tilesize * 44;
		speed = 4;
		direction = "down";
		
		//PLAYER STATUS
		maxLife = 6;
		life = maxLife;
		
	}
	
	public void getPlayerImage() {
				
	up1 = setup("/player/elf_back_walk1");
	up2 = setup("/player/elf_back_walk2");
	up3 = setup("/player/elf_back_walk3");
	down1 = setup("/player/elf_front_walk1");
	down2 = setup("/player/elf_front_walk2");
	down3 = setup("/player/elf_front_walk3");
	right1 = setup("/player/elf_side01_walk1");
	right2 = setup("/player/elf_side01_walk2");
	right3 = setup("/player/elf_side01_walk3");
	left1 = setup("/player/elf_side02_walk1");
	left2 = setup("/player/elf_side02_walk2");
	left3 = setup("/player/elf_side02_walk3");

	}
	
	
	
	public void update() {

		if(KeyH.UpFlag == true || KeyH.DownFlag == true || KeyH.LeftFlag == true||
				KeyH.RightFlag == true) {
		
		
			if(KeyH.UpFlag == true) {
				direction = "up";
				
			}else if(KeyH.LeftFlag == true) {
				direction = "left";
				
			}else if(KeyH.DownFlag == true) {
				direction = "down";
				
			}else if(KeyH.RightFlag == true) {
				direction = "right";
				
			}
			
			//check tile collision 
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			
			// check object collision 
			int objIndex = gp.cChecker.checkObject(this, true);
			pickupObject(objIndex);
			
			//npc collision
			int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
			interactNPC(npcIndex);
			//if collision false, player can move 
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
		
	}
	
	public void pickupObject(int i) {
		
		if(i != 999) {
		
		}
	}
	
	public void interactNPC(int i) {
		if(i != 999) {
			
			if(gp.KeyH.enterPressed == true) {
				
				gp.gameState = gp.dialogueState;
				gp.npc[i].speak();	
			}
		}
		gp.KeyH.enterPressed = false;
	}
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		//g2.fillOval(x, y, gp.tilesize, gp.tilesize);
		
		BufferedImage image = null;
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
