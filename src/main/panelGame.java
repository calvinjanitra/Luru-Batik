package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


import Entity.Player;
import tile.TileManager;

public class panelGame extends JPanel implements Runnable{

	//screen settings
	final int OGTileSize = 16;
	//assume computer resolution = 1080p 
	//then we need to scale it 
	final int Scale = 3;
	//final int Scale = 1;
	public final int tilesize = OGTileSize * Scale; //menjadi 48x48 px
	
	public int screencol = 16;
	public int screenrow = 12;
	public final int panjangScreen = screencol * tilesize; // 16 * 48 = 768px 
	public final int TinggiScreen = screenrow * tilesize; // 12 * 48 = 576 px
	
	//WORLD SETTINGS 
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tilesize * maxWorldCol;
	public final int worldHeight = tilesize * maxWorldRow;
	
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyInputHandler KeyH = new KeyInputHandler(); // this handles keyboard awsd input
	Thread gameThread;//keeps your program running until you stop it
	public Player player = new Player(this, KeyH);
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
			repaint();
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
		
		player.update();
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
		
	}	
	
}
