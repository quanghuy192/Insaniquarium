
import javax.swing.JFrame;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SeaAgent extends Agent implements Runnable {

	private static final long serialVersionUID = 4761222511545150978L;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	int x, y;
	private int step = 0;
	MouseAction action ;

	@Override
	protected void setup() {
		super.setup();
		init();
		addBehaviour(new FeedBaitRequestBahavious());
	}

	public void init() {
		SeaView sea = new SeaView(this);
		action = MouseAction.getInstance(this);
		sea.addMouseListener(action);
		
		JFrame mainPlay = new JFrame();
		mainPlay.setVisible(true);
		mainPlay.setSize(WIDTH, HEIGHT);
		mainPlay.setLocationRelativeTo(null);
		mainPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPlay.getContentPane().add(sea);
	}

	private class FeedBaitRequestBahavious extends CyclicBehaviour {

		private static final long serialVersionUID = -7345540395070843437L;

		@Override
		public void action() {
			System.out.println(step);
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
		setStep(0);
		System.out.println("---" + step);
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
