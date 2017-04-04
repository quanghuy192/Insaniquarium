

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jade.core.Agent;

public class SeaView extends javax.swing.JPanel {

	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final long serialVersionUID = 7860966868388551567L;
	
	public SeaView(Agent agent) {
		
		JLabel bg = new JLabel(new ImageIcon(SeaAgent.class.getResource("/sea.jpg")));
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
	    setLayout(null);
	    setSize(WIDTH, HEIGHT);
	    setVisible(true);
	    add(bg);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
	}
}
