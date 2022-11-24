package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldX, worldY;
	public int speed;
	 
	
	public BufferedImage up1, up2, up3, left1, left2, left3;
	public BufferedImage right1, right2, right3, down1, down2, down3;
	
	public String direction;
	
	public int charcounter = 0;
	public int charnumber = 1;
	
	public Rectangle solidArea;
	public int solidAreaDefX, solidAreaDefY;
	public boolean collisionOn = false;
}