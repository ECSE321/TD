package main.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.model.IObserver;
import main.model.Observable;
import main.model.Player;

public class PurchaseView extends TDPanel {
	private JLabel healthLabel;
	private JLabel goldLabel;
	
	private JButton purchaseTowerA;
	private JButton purchaseTowerB;
	private JButton purchaseTowerC;
	private JButton purchaseTowerD;
	
	public PurchaseView() {
		this.setLayout(new FlowLayout());
		this.setSize(100,100);
		
		healthLabel = new JLabel("health: 100/100");
		goldLabel = new JLabel("gold: 1000");
		
		purchaseTowerA = new JButton("TowerA");
		purchaseTowerB = new JButton("TowerB");
		purchaseTowerC = new JButton("TowerC");
		purchaseTowerD = new JButton("TowerD");
		
		this.add(healthLabel);
		this.add(goldLabel);
		this.add(purchaseTowerA);
		this.add(purchaseTowerB);
		this.add(purchaseTowerC);
		this.add(purchaseTowerD);
	}
	
	public JLabel getHealthLabel() {
		return healthLabel;
	}
	
	public JLabel getGoldLabel() {
		return goldLabel;
	}
	
	public JButton[] getPurchaseButtons() {
		JButton[] purchaseButtons = {purchaseTowerA, purchaseTowerB, purchaseTowerC, purchaseTowerD};
		return purchaseButtons;
	}
	
	@Override
	public void update(Observable o, String arg) {
		if(arg == "GoldChange") {
			int gold = ((Player)o).getGold();
			goldLabel.setText("gold: " + gold);
		}
		if(arg == "Health damage") {
			int health = ((Player)o).getHealth();
			healthLabel.setText("healh: " + health + "/100");
		}
	}
}
