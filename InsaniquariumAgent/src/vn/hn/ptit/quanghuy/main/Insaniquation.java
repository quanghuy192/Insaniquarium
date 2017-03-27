package vn.hn.ptit.quanghuy.main;

import javax.swing.JFrame;

import vn.hn.ptit.quanghuy.view.SeaView;

public class Insaniquation {
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;

	public static void main(String[] args){
		
		SeaView sea = new SeaView();
		
		JFrame mainPlay = new JFrame();
		mainPlay.setVisible(true);
		mainPlay.setSize(WIDTH, HEIGHT);
		mainPlay.setLocationRelativeTo(null);
		mainPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPlay.getContentPane().add(sea);
	}
	
}
