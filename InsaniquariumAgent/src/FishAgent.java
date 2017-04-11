
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class FishAgent extends Agent {

	private static final long serialVersionUID = -8234965834472588639L;
	public static Fish fish;
	MouseAction action;
	
	public void createFish(SeaView parent, int x, int y) {
		fish = new Fish(parent, x, y);
	}
	
	@Override
	protected void setup() {
		super.setup();
		action = MouseAction.getInstance(this);
		addBehaviour(new FeedBackBehaviour());
	}

	private class FeedBackBehaviour extends CyclicBehaviour {

		private static final long serialVersionUID = -1552163707564697354L;

		@Override
		public void action() {
			ACLMessage messageFeedBack = receive();
			if (null != messageFeedBack && messageFeedBack.getContent() != null
					&& messageFeedBack.getContent().length() > 0) {
				System.out.println(messageFeedBack);
				String content = messageFeedBack.getContent();
				String[] arrContent = content.split("/");
				try {
					if (content.length() > 2 && arrContent[0].equalsIgnoreCase("fish")) {
						int targetX = Integer.parseInt(arrContent[1]);
						int targetY = Integer.parseInt(arrContent[2]);
						
						if(null != fish){
							fish.findBait(targetX, targetY);
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				// doDelete();
			}
		}
	}
}
