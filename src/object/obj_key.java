package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class obj_key extends SuperObject{

	public obj_key() {
		
		name = "key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/01.png"));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		collision = true;
		
	}
}
