package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class obj_chest_brown extends SuperObject{

	 public obj_chest_brown() {
		// TODO Auto-generated constructor stub
		 name = "chest";
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/objects/chests_1.png"));
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			collision = true;
	}
}
