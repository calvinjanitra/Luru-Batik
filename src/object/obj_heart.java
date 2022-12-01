package object;

import javax.imageio.ImageIO;

import main.panelGame;

public class obj_heart extends SuperObject {
	panelGame gp;
	
	public obj_heart(panelGame gp) {
		this.gp = gp;
		name = "Heart";
		
		try {
//			image = ImageIO.read(null);
//			image2 = ImageIO
//			image3 = ;
//			image = uTool.scaleImage(image, solidAreaDefY, solidAreaDefX);
//			image2 = uTool.scaleImage(image, solidAreaDefY, solidAreaDefX);
//			image3 = uTool;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
