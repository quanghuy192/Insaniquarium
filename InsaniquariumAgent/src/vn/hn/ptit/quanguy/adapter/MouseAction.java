package vn.hn.ptit.quanguy.adapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vn.hn.ptit.quanghuy.agent.BaitAgent;
import vn.hn.ptit.quanghuy.view.SeaView;

public class MouseAction implements MouseListener {
	
	private static MouseAction action = new MouseAction();
	private int x;
	private int y;
	SeaView sea;
	
	private MouseAction() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked at !!!" + e.getX() + "," + e.getY());
		
		// get location of bait
		x = e.getX();
		y = e.getY();
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
	
	public static MouseAction getInstance(){
		return action;
	}
	
	public static void feedBait(int x, int y){
		BaitAgent bait = new BaitAgent(x, y);
	}

}
