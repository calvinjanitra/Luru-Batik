package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener{

	public boolean UpFlag, DownFlag, LeftFlag, RightFlag;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int kode = e.getKeyCode();
		
		if(kode == KeyEvent.VK_W) {
			UpFlag = true;
		}if(kode == KeyEvent.VK_A) {
			LeftFlag = true;
		}if(kode == KeyEvent.VK_S) {
			DownFlag = true;
		}if(kode == KeyEvent.VK_D) {
			RightFlag = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int kode = e.getKeyCode();
		
		if(kode == KeyEvent.VK_W) {
			UpFlag = false;
		}if(kode == KeyEvent.VK_A) {
			LeftFlag = false;
		}if(kode == KeyEvent.VK_S) {
			DownFlag = false;
		}if(kode == KeyEvent.VK_D) {
			RightFlag = false;
		}
	}

}
