

import javax.swing.JFrame;

import jade.core.Agent;

public class SeaAgent extends Agent{

	private static final long serialVersionUID = 4761222511545150978L;
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	@Override
	protected void setup() {
		super.setup();
		init();
	}
	
	public void init(){
		SeaView sea = new SeaView();
		
		JFrame mainPlay = new JFrame();
		mainPlay.setVisible(true);
		mainPlay.setSize(WIDTH, HEIGHT);
		mainPlay.setLocationRelativeTo(null);
		mainPlay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPlay.getContentPane().add(sea);
	}

}
