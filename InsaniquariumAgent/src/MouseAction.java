
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseAction implements MouseListener {

	private static MouseAction action = new MouseAction();
	private int x;
	private int y;
	private static SeaAgent seaAgent;

	private MouseAction() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked at !!!" + e.getX() + "," + e.getY());

		// get location of bait
		x = e.getX();
		y = e.getY();

		if (null != seaAgent) {
			seaAgent.sendMsgBaitPoristion(x, y);
			System.out.println(x + "" + y);
		}
		BaitAgent bait = new BaitAgent(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// No thing to do
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
