package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Entity.Entity;
import Entity.Player;
import object.SuperObject;
import tile.TileManager;

public class panelGame extends JPanel implements Runnable{

	//screen settings
	final int OGTileSize = 16;
	//assume computer resolution = 1080p 
	//then we need to scale it 
	final int Scale = 3;
	//final int Scale = 1;
	public final int tilesize = OGTileSize * Scale; //menjadi 48x48 px
	
	public int screencol = 20;
	public int screenrow = 12;
	public final int panjangScreen = screencol * tilesize; // 16 * 48 = 768px 
	public final int TinggiScreen = screenrow * tilesize; // 12 * 48 = 576 px
	
	//FULL SCREEN SETTINGS
	int panjangScreen2 = panjangScreen;
	int TinggiScreen2 = TinggiScreen;
	BufferedImage tempScreen;
	Graphics2D g2;
	
	//WORLD SETTINGS 
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	//GAME STATE
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;
	
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	public KeyInputHandler KeyH = new KeyInputHandler(this); // this handles keyboard awsd input
	Sound music = new Sound();
	Sound soundEffect = new Sound();
	
	public CollisionChecker cChecker = new CollisionChecker(this);
	public Player player = new Player(this, KeyH);
	public SuperObject obj[] = new SuperObject[10];
	public Entity npc[] = new Entity[10];
	public assetSetter aSetter = new assetSetter(this);
	public UI ui = new UI(this);
	
	
	
	Thread gameThread;//keeps your program running until you stop it
	
	//set default position
	int playerx = 100;
	int playery = 100;
	int playerspeed = 4;
	
	
	public panelGame() {
		
		this.setPreferredSize(new Dimension(panjangScreen, TinggiScreen ));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //reduce flickering issue
		//drawing graphics into offscreen image buffer first
		//memory intensive		
		this.addKeyListener(KeyH);
		this.setFocusable(true);
	}

	
	public void setupGame() {
		aSetter.setObject();
		aSetter.setNPC();
		playMusic(0);
		stopMusic();
		gameState = titleState;
		
		tempScreen = new BufferedImage(panjangScreen, TinggiScreen, BufferedImage.TYPE_INT_BGR);
		g2 = (Graphics2D) tempScreen.getGraphics();
		
		setFullScreen();
		
	}
	
	public void setFullScreen() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(Main.window);
		
		panjangScreen2 = Main.window.getWidth();
		TinggiScreen2 = Main.window.getHeight();
	}
	public void startThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		double interval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + interval;
		
		
		while(gameThread != null) {

			//1 update, information such as position etc
			update();
			//2 draw, draw environment etc
			drawToTempScreen();
			drawToScreen();
			//we do this per fps
			
			
			
			try {
				double timeLeft = nextDrawTime - System.nanoTime();
				timeLeft = timeLeft/1000000;
				
				if(timeLeft < 0) {
					timeLeft = 0;
				}
				Thread.sleep((long) timeLeft);
				
				nextDrawTime += interval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		

		if(gameState == playState) {
			player.update();	
			
			for(int i = 0; i< npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
		}
		
		if(gameState == pauseState) {
			//nothing
			
		}
		if(gameState == dialogueState) {
			//
		}
		
	}
	
	public void drawToTempScreen() {
		// title screen
		if(gameState == titleState) {
			ui.draw(g2);
		}else {
			tileM.draw(g2);
			
			
			//object draw
			for(int i = 0; i < obj.length; i++) {
				if(obj[i] != null) {
					obj[i].draw(g2, this);
				}
			}
			
			//npc 
			for(int i=0; i<npc.length; i++) {
				if(npc[i] != null) {
					npc[i].draw(g2);
				}
			}
			
			player.draw(g2);
			
			ui.draw(g2);
		}
	}	
	
	public void drawToScreen() {
		Graphics g = getGraphics();
		g.drawImage(tempScreen, 0, 0, panjangScreen2, TinggiScreen2, null);
		g.dispose();
	}
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		
		music.stop();
	}
	
	public void playSE(int i) {
		
		soundEffect.setFile(i);
		soundEffect.play();
	}
	
}
