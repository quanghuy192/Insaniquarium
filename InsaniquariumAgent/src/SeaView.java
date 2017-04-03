

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jade.core.Agent;

public class SeaView extends javax.swing.JPanel {

	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private static final long serialVersionUID = 7860966868388551567L;
	
	public SeaView(Agent agent) {
		
		ImageIcon img = new ImageIcon("sea.jpg");
		JLabel bg = new JLabel(img);
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
		JPanel p = new JPanel();
	    p.setLayout(null);
	    p.setSize(WIDTH, HEIGHT);
	    p.setVisible(true);
	    p.add(bg);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
	}


}
