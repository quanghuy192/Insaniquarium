
import javax.swing.JFrame;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SeaAgent extends Agent implements Runnable {

	private static final long serialVersionUID = 4761222511545150978L;

	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	private static final JFrame mainPlay = new JFrame();
	private static SeaView sea;
	
	int x, y;
	private static int step = 0;
	MouseAction action ;

	@Override
	protected void setup() {
		super.setup();
		init();
		addBehaviour(new FeedBaitRequestBahavious());
	}

	public void init() {

		sea = new SeaView(this);
		
		mainPlay.setVisible(true);
		mainPlay.setSize(WIDTH, HEIGHT);
		mainPlay.setLocationRelativeTo(null);
		mainPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		action = MouseAction.getInstance(this);
		mainPlay.getContentPane().add(sea);
		
		mainPlay.addMouseListener(action);
	}

	public JFrame getMainPlay() {
		return mainPlay;
	}

	public SeaView getSea() {
		return sea;
	}

	private class FeedBaitRequestBahavious extends CyclicBehaviour {

		private static final long serialVersionUID = -7345540395070843437L;

		@Override
		public void action() {
			switch (step) {
			case 0:
				// Send request to update bait position
				ACLMessage feedBaitRequest = new ACLMessage(ACLMessage.INFORM);
				feedBaitRequest.setContent(x + "/" + y);
				feedBaitRequest.addReceiver(new AID("FishAgent", AID.ISLOCALNAME));
				send(feedBaitRequest);
				step++;
				break;

			case 1:
				// Nothing
				break;

			case 2:
				// Finish
				doDelete();
				break;

			default:
				// Finish
				doDelete();
				break;
			}
		}
	}

	public void sendMsgBaitPoristion(int x, int y) {
		this.x = y;
		this.y = y;
		step = 0;
	}
}
