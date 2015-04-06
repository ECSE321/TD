package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import main.model.GameLogic;
import main.model.Player;
import main.view.PurchaseView;
import main.view.TDPanel;

public class PurchaseController {
	private PurchaseView view;
	private Player model;
	private ActionListener purchaseTowerAListener;
	private ActionListener purchaseTowerBListener;
	private ActionListener purchaseTowerCListener;
	private ActionListener purchaseTowerDListener;
	
	public PurchaseController(PurchaseView view, Player p) {
		this.view = view;
		this.model = p;
		
		purchaseTowerAListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p.makePurchase(100);
			}
		};
		
		purchaseTowerBListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO add action
			}
		};
		
		purchaseTowerCListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO add action
			}
		};
		
		purchaseTowerDListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO add action
			}
		};
		
		view.getPurchaseButtons()[0].addActionListener(purchaseTowerAListener);
		view.getPurchaseButtons()[1].addActionListener(purchaseTowerBListener);
		view.getPurchaseButtons()[2].addActionListener(purchaseTowerCListener);
		view.getPurchaseButtons()[3].addActionListener(purchaseTowerDListener);
	}
}
