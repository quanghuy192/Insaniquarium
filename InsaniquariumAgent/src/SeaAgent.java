
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SeaAgent extends Agent{

	private static final long serialVersionUID = 4761222511545150978L;

	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	private static JFrame mainPlay = new JFrame();
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
		action = MouseAction.getInstance(this);
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

        		mainPlay.setVisible(true);
        		mainPlay.setSize(WIDTH, HEIGHT);
        		mainPlay.setLayout(new BorderLayout());
        		mainPlay.setLocationRelativeTo(null);
        		mainPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           		mainPlay.getContentPane().add(sea);
        		
        		mainPlay.addMouseListener(action);
            }
        });
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
