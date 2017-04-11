
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import jade.core.Agent;

public class MouseAction implements MouseListener {

	private static MouseAction action = new MouseAction();
	private int x;
	private int y;
	private static SeaAgent seaAgent;
	private static FishAgent fishAgent;
	private BufferedImage imgeFish;

	private MouseAction() {
		URL resource = getClass().getResource("/nemo.png");
		try {
			imgeFish = ImageIO.read(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Nothing to do
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Clicked at !!!" + e.getX() + "," + e.getY());

		// get location of bait
		x = e.getX();
		y = e.getY();

		if (null != seaAgent) {
			seaAgent.sendMsgBaitPoristion(x, y);
			System.out.println(x + "-" + y);
		}

    	final Bait bait = new Bait(seaAgent.getSea(), x, y);
		List<Bait> baits = seaAgent.getSea().getBaits();
		baits.add(bait);
		
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Bait b : baits) {
                    b.move();
                }
                seaAgent.getSea().repaint();
            }
        });
        timer.start();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// No thing to do
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// No thing to do
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// No thing to do
	}

	public static MouseAction getInstance(Agent agent) {
		
		if(agent instanceof SeaAgent){
			MouseAction.seaAgent = (SeaAgent) agent;
		}
		
		if(agent instanceof FishAgent){
			addFish(agent);
		}
		
		return action;
	}
	
	private static void addFish(Agent agent) {
		if(agent instanceof FishAgent){
			MouseAction.fishAgent = (FishAgent) agent;
			fishAgent.createFish(seaAgent.getSea(), 20, 20);
			FishAgent.fish.move();
			seaAgent.getSea().repaint();
		}
	}
}
