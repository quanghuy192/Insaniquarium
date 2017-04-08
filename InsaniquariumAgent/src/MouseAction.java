
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Timer;

public class MouseAction implements MouseListener {

	private static MouseAction action = new MouseAction();
	private int x;
	private int y;
	private static SeaAgent seaAgent;

	private MouseAction() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		System.out.println("Clicked at !!!" + e.getX() + "," + e.getY());

		// get location of bait
		x = e.getX();
		y = e.getY();

		if (null != seaAgent) {
			seaAgent.sendMsgBaitPoristion(x, y);
			System.out.println(x + "-" + y);
		}

		
		Bait bait = new Bait(x, y);
		seaAgent.getSea().add(bait);
		List<Bait> baits = seaAgent.getSea().getBaits();
		baits.add(bait);
		Thread t = new Thread(new Runnable() {

			int bX;
			int bY = bait.getY();

			@Override
			public void run() {
				while (true) {
					try {
						bX = RandomUtilities.getXPosition(bait.getX());
						bY++;
						bait.setX(bX);
						bait.setY(bY);
						System.out.println(bX + "---" + bY);
						seaAgent.getSea().repaint();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		
		Bait bait = new Bait(seaAgent.getSea(), x, y);
		List<Bait> baits = seaAgent.getSea().getBaits();
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		// add(bg);
                // if (baits.isEmpty()) {
                	baits.add(bait);
                // }

                // if (rand.nextBoolean()) {
                //	baits.add(new Bait(SeaView.this));
                // }

                for (Bait b : baits) {
                    b.move();
                }
                seaAgent.getSea().repaint();
            }
        });
        timer.start();
        */
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

		/*
		Bait bait = new Bait(x, y);
		seaAgent.getSea().add(bait);
		List<Bait> baits = seaAgent.getSea().getBaits();
		baits.add(bait);
		Thread t = new Thread(new Runnable() {

			int bX;
			int bY = bait.getY();

			@Override
			public void run() {
				while (true) {
					try {
						bX = RandomUtilities.getXPosition(bait.getX());
						bY++;
						bait.setX(bX);
						bait.setY(bY);
						System.out.println(bX + "---" + bY);
						seaAgent.getSea().repaint();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();
		*/

    	final Bait bait = new Bait(seaAgent.getSea(), x, y);
		List<Bait> baits = seaAgent.getSea().getBaits();
		baits.add(bait);
		
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
        		// add(bg);
                // if (baits.isEmpty()) {
                	
                // }

                // if (rand.nextBoolean()) {
                //	baits.add(new Bait(SeaView.this));
                // }

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

	public static MouseAction getInstance(SeaAgent seaAgent) {
		MouseAction.seaAgent = seaAgent;
		return action;
	}
}
