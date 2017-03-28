

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeaView extends javax.swing.JPanel implements Runnable{

	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private static final long serialVersionUID = 7860966868388551567L;
	
	MouseAction action ;
	
	public SeaView() {
		
		ImageIcon img = new ImageIcon("sea.jpg");
		JLabel bg = new JLabel(img);
		bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		JPanel p = new JPanel();
	    p.setLayout(null);
	    p.setSize(WIDTH, HEIGHT);
	    p.setVisible(true);
	    p.add(bg);
		
		action = MouseAction.getInstance();
		addMouseListener(action);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
	}

	@Override
	public void run() {
		
	}
}
