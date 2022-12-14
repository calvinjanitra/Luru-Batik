package Entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.UtilityTool;
import main.panelGame;

public class NPC_Bakul extends Entity {

	public NPC_Bakul(panelGame gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		
		direction = "down";
		speed = 0;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		
	up1 = setup("/npc/up1");
	up2 = setup("/npc/up2");
	up3 =setup("/npc/up3");
	down1 = setup("/npc/down1");
	down2 = setup("/npc/down2");
	down3 = setup("/npc/down3");
	right1 = setup("/npc/right1");
	right2 = setup("/npc/right2");
	right3 = setup("/npc/right3");
	left1 = setup("/npc/left1");
	left2 = setup("/npc/left2");
	left3 = setup("/npc/left3");

	}
	
	public void setDialogue() {
		dialogues[0] = "Hello, kid";
		dialogues[1] = "tugasmu adalah untuk \nmengumpulkan Batik-Batik";
		dialogues[2] = "benar, Batik kain yang \nsering kita pakai";
		dialogues[3] = "Batik-batik ini telah disebar \ndi sekitar kita";
		dialogues[4] = "Gunakan kunci untuk \nmembuka chest";
		
	}
	
	
	public void setAction() {
		
		//actionLockCounter++;
		//
		//if(actionLockCounter == 20) {
		//	
		//	Random rand = new Random();
		//	int i = rand.nextInt(20)+1;
		//	
		//	if(i <= 10) {
		//		direction = "up";
		//	}if(i> 10 && i <= 20) {
		//		direction = "down";
		//	}
		//	actionLockCounter = 0;
		//}
		//
	}
	
	public void speak() {
		
		super.speak();
	}

}
