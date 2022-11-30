package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.panelGame;

public class obj_chest_brown extends SuperObject{

	panelGame gp;
	 public obj_chest_brown(panelGame gp) {
		// TODO Auto-generated constructor stub
		 name = "chest";
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/objects/chests_1.png"));
				uTool.scaleImage(image, gp.tilesize, gp.tilesize);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			collision = true;
	}
}
