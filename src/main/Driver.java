package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.model.Player;
import main.view.PurchaseView;
import main.view.TDPanel;

public class Driver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame;
				frame = new JFrame("TD");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
				frame.setSize(200,200);        
				frame.setVisible(true);
				
				TDPanel PV = new PurchaseView();
				frame.add(PV);
				
				Player p = new Player(100, 1000, 1);
				p.addObserver(PV);
				
				p.makePurchase(10);
			}
	});
	}
}
