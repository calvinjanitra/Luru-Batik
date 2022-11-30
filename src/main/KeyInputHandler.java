package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputHandler implements KeyListener{
	
	panelGame gp;
	public boolean UpFlag, DownFlag, LeftFlag, RightFlag, enterPressed;
	
	public KeyInputHandler(panelGame gp) {
		this.gp = gp;
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int kode = e.getKeyCode();
		//title state
		if(gp.gameState == gp.titleState) {
			if(kode == KeyEvent.VK_W) {
				gp.ui.command--;
				if(gp.ui.command < 0) {
					gp.ui.command = 2;
				}
			}
			if(kode == KeyEvent.VK_S) {
				gp.ui.command++;
				if(gp.ui.command > 2) {
					gp.ui.command = 0;
				}		
		}
			if(kode == KeyEvent.VK_ENTER) {
				if(gp.ui.command == 0) {
					gp.gameState = gp.playState;
					gp.playMusic(0);
				}
				if(gp.ui.command == 1) {
			
				}
				if(gp.ui.command == 2) {
					System.exit(0);
				}
			}
	}
		
		
		
		
		
		//playstate
		if(gp.gameState == gp.playState) {
			
			if(kode == KeyEvent.VK_W) {
				UpFlag = true;
			}if(kode == KeyEvent.VK_A) {
				LeftFlag = true;
			}if(kode == KeyEvent.VK_S) {
				DownFlag = true;
			}if(kode == KeyEvent.VK_D) {
				RightFlag = true;
			}if(kode == KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
			}if(kode == KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
		}
		
		//pause state 
		else if(gp.gameState == gp.pauseState) {
			if(kode == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
			}
		}
		
		// dialogue state
		else if(gp.gameState == gp.dialogueState) {
			if(kode == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
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
