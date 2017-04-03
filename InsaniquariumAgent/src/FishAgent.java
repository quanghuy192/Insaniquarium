

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class FishAgent extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3751487164232308312L;
	
	@Override
	protected void setup() {
		super.setup();
		addBehaviour(new FeedBackBehaviour());
	}
	
	private class FeedBackBehaviour extends CyclicBehaviour{
		
		private static final long serialVersionUID = -1552163707564697354L;

		@Override
		public void action() {
			ACLMessage messageFeedBack = receive();
			if(null != messageFeedBack){
				System.out.println(messageFeedBack);
				
				doDelete();
			}
		}
	}

}
