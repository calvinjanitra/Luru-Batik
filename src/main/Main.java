package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Luru Batik");
		
		panelGame gamePanel = new panelGame();
		window.add(gamePanel);
		
		window.pack(); //causes this window to be sized to fit the preferred size
		//and layout of its subcomponent
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startThread();
	}
}
