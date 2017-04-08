

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import jade.core.Agent;

public class SeaView extends javax.swing.JPanel {

	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final int SIZE = 7;
	private BufferedImage image;
	private static final long serialVersionUID = 7860966868388551567L;
	private static List<Bait> baits ;
	private Random rand;
	
	public SeaView(Agent agent) {
		
		baits = new ArrayList<>();
		URL resource = getClass().getResource("/sea.jpg");
		try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
		// JLabel bg = new JLabel(new ImageIcon(SeaAgent.class.getResource("/sea.jpg")));
		// bg.setBounds(0, 0, WIDTH, HEIGHT);
		
		// rand = new Random(System.currentTimeMillis());
		/*
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		// add(bg);
                if (baits.isEmpty()) {
                	baits.add(new Bait(SeaView.this));
                }

                if (rand.nextBoolean()) {
                	baits.add(new Bait(SeaView.this));
                }

                for (Bait b : baits) {
                    b.move();
                }
                repaint();
            }
        });
        timer.start();
        */
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(image, 0, 0, this);
		
        for (Bait b : baits) {
            b.paint(g2d);
        }
        g2d.dispose();
	}
	
	public void addBait(Bait b){
		baits.add(b);
	}
	
	public List<Bait> getBaits(){
		return baits;
	}
}
