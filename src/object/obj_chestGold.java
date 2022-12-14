package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.panelGame;

public class obj_chestGold extends SuperObject{

panelGame gp;

		  public obj_chestGold(panelGame gp) {
			// TODO Auto-generated constructor stub
			 name = "chest_gold";
				try {
					image = ImageIO.read(getClass().getResourceAsStream("/objects/chest_3.png"));
					uTool.scaleImage(image, gp.tilesize, gp.tilesize);
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				collision = true;
		
	}

}
