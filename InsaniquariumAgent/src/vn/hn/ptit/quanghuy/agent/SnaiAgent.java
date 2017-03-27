package vn.hn.ptit.quanghuy.agent;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

public class SnaiAgent extends Agent {

	private static final long serialVersionUID = -5464460174680111772L;
	
	private static final int TIME_OUT = 10000;
	
	WakerBehaviour simpleBehaviour = new WakerBehaviour(this, TIME_OUT) {

		private static final long serialVersionUID = -1340476332579583713L;
		
		protected void handleElapsedTimeout() {
	        // perform operation X
			System.out.println("Time out !! Ting Ting");
		}
	};
	
	@Override
	protected void setup() {
		super.setup();
		
		// Init behaviour
		addBehaviour(simpleBehaviour);
	}
	
	@Override
	protected void takeDown() {
		super.takeDown();
	}

}
