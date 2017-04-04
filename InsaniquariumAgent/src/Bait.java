import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bait extends  JPanel implements Runnable{
	
	private int x;
	private int y;
	private static final int SIZE = 5;
	private static final long serialVersionUID = 6387213912470106375L;
	private JFrame context;
	
	public Bait(int x, int y, JFrame context) {
		super();
		this.x = x;
		this.y = y;
		this.context = context;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.WHITE);
		g2D.drawRect(x, y, SIZE, SIZE);
	}
	
	@Override
	public void run() {
		while(y < 480){
			try {
				x = RandomUtilities.getXPosition(x);
				y++;
				System.out.println(x + "---" + y);
				context.repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
