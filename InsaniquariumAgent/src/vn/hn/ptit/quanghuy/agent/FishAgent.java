package vn.hn.ptit.quanghuy.agent;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class FishAgent extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3751487164232308312L;
	
	@Override
	protected void setup() {
		super.setup();
		
		ACLMessage msg = receive();
		if(null != msg){
			String title = msg.getContent();
			System.out.println(title);
			
			ACLMessage reply = msg.createReply();
			reply.setPerformative(ACLMessage.PROPOSE);
		    reply.setContent("Done !");
		    send(reply);
		}
	}

}
