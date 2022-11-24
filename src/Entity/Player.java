package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyInputHandler;
import main.panelGame;
import object.obj_chest_brown;

public class Player extends Entity{

	panelGame panel;
	KeyInputHandler KeyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(panelGame panel, KeyInputHandler keyH) {
		
		this.panel = panel;
		this.KeyH = keyH;
		
		screenX = panel.panjangScreen/2 - (panel.tilesize/2);
		screenY = panel.TinggiScreen/2 - (panel.tilesize/2);
		
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
		worldX = panel.tilesize * 24;
		worldY = panel.tilesize * 44;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/elf_back_walk1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/elf_back_walk2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/elf_back_walk3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/elf_front_walk1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/elf_front_walk2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/elf_front_walk3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/elf_side01_walk1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/elf_side01_walk2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/elf_side01_walk3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/elf_side02_walk1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/elf_side02_walk2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/elf_side02_walk3.png"));
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
			panel.cChecker.checkTile(this);
			
			
			// check object collision 
			int objIndex = panel.cChecker.checkObject(this, true);
			pickupObject(objIndex);
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
			String objectName = panel.obj[i].name;
			
			switch(objectName) {
			case "key":
				panel.playSE(1);
				hasKey++;
				panel.obj[i] = null;
				break;
			case "chest":
				if(hasKey > 0) {
					panel.obj[i] = null;
					hasKey--;
				}
				break;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		//g2.fillOval(x, y, panel.tilesize, panel.tilesize);
		
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
		g2.drawImage(image, screenX, screenY, panel.tilesize, panel.tilesize, null);
		
	}
}
