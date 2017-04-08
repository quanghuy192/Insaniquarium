import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Bait extends  JPanel{
	
	public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    private int x;
    private int y;

    private int deltaX;
    private int deltaY;

    private Color color;
    private SeaView parent;

    public Bait(SeaView parent) {
        this.parent = parent;
        // x = parent.getWidth() / 2;
        // y = parent.getHeight() / 2;

        deltaX = RandomUtilities.random(-4, 4);
        deltaY = RandomUtilities.random(-4, 4);

        color = new Color(RandomUtilities.random(0, 255), RandomUtilities.random(0, 255), RandomUtilities.random(0, 255));
    }
    
    public Bait(SeaView parent, int x, int y) {
        this.parent = parent;

        this.x = x;
        this.y = y;
        deltaX = RandomUtilities.random(-4, 4);
        deltaY = RandomUtilities.random(-4, 4);

        color = new Color(RandomUtilities.random(0, 255), RandomUtilities.random(0, 255), RandomUtilities.random(0, 255));
    }

    public void move() {
    	/*
        x += deltaX;
        y += deltaY;

        if (x + WIDTH > parent.getWidth()) {
            x = parent.getWidth() - WIDTH;
            deltaX *= -1;
        } else if (x < 0) {
            x = 0;
            deltaX *= -1;
        }
        if (y + HEIGHT > parent.getHeight()) {
            y = parent.getHeight() - HEIGHT;
            deltaY *= -1;
        } else if (y < 0) {
            y = 0;
            deltaY *= -1;
        }
        */
    	x = RandomUtilities.getXPosition(x);
		y++;
    }

    public Color getColor() {
        return color;
    }

    public void paint(Graphics2D g2d) {

        g2d.setColor(getColor());
        g2d.fillOval(x, y, WIDTH, HEIGHT);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, WIDTH, HEIGHT);

    }        

}
