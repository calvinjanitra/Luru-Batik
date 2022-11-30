package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.panelGame;

public class obj_key extends SuperObject{

	panelGame gp;
	
	public obj_key(panelGame gp) {
		
		name = "key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/01.png"));
			uTool.scaleImage(image, gp.tilesize, gp.tilesize);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
