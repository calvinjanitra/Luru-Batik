package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.KeyInputHandler;
import main.panelGame;

public class Player extends Entity{

	panelGame panel;
	KeyInputHandler KeyH;
	
	public Player(panelGame panel, KeyInputHandler keyH) {
		
		this.panel = panel;
		this.KeyH = keyH;
		
		setDefaultValue();
	}

	public void setDefaultValue() {
		x = 100;
		y = 100;
		speed = 5;
	}
	
	public void update() {

		if(KeyH.UpFlag == true) {
			y -= speed;
		}if(KeyH.LeftFlag == true) {
			x -= speed;
		}if(KeyH.DownFlag == true) {
			y += speed;
		}if(KeyH.RightFlag == true) {
			x += speed;
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setColor(Color.white);
		g2.fillOval(x, y, panel.tilesize, panel.tilesize);
	}
}
