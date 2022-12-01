package main;

import javax.swing.JFrame;

public class Main {
	public static JFrame window;
	
	public static void main(String[] args) {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Luru Batik");
		window.setUndecorated(true);
		
		panelGame gamePanel = new panelGame();
		window.add(gamePanel);
		
		window.pack(); //causes this window to be sized to fit the preferred size
		//and layout of its subcomponent
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startThread();
	}
}
