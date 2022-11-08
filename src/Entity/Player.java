package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyInputHandler;
import main.panelGame;

public class Player extends Entity{

	panelGame panel;
	KeyInputHandler KeyH;
	
	public Player(panelGame panel, KeyInputHandler keyH) {
		
		this.panel = panel;
		this.KeyH = keyH;
		
		setDefaultValue();
		getPlayerImage();
	}

	
	public void setDefaultValue() {
		x = 100;
		y = 100;
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
				y -= speed;
			}if(KeyH.LeftFlag == true) {
				direction = "left";
				x -= speed;
			}if(KeyH.DownFlag == true) {
				direction = "down";
				y += speed;
			}if(KeyH.RightFlag == true) {
				direction = "right";
				x += speed;
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
		g2.drawImage(image, x, y, panel.tilesize, panel.tilesize, null);
		
	}
}
