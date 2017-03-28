

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class BaitAgent extends Agent {
	
	private int x;
	private int y;
	private static final long serialVersionUID = 6387213912470106375L;
	
	public BaitAgent(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected void setup() {
		super.setup();
		
		x = 30;
		y = 30;
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("Peter", AID.ISLOCALNAME));
		msg.setLanguage("English");
		msg.setOntology("Weather-forecast-ontology");
		msg.setContent("Today it’s raining at :" + x + "," + y);
		System.out.println(msg.getContent());
		send(msg);
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
	
	

}
