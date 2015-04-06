package main.model;


import java.util.LinkedList;

import main.model.critter.*;
import main.model.map.Map;

public class CritterMonitor extends Thread {
	
	private CritterManager critterManager;
	private Player player;
	private Map map;
	
	Vector2D spawnPoint;
	Vector2D endPoint;
	
	//Constant
	private int DELAY = 1500; //Delay between each new Critter in ms
	private int REFRESH_RATE = 500; //Delay between each check for critter at end
	private double STEAL_RATE = 0.00001;
	
	public CritterMonitor(CritterManager cm, Player p, Map m) {
		this.critterManager = cm;
		this.player = p;
		this.map = m;
		this.spawnPoint = map.getFirstTile().getCenterDrawPosition();
		this.endPoint = map.getLastTile().getPosition();
	}
	
	public void run(){
		int currentLevel = player.getLevel();
		for(int i=0;i<2*currentLevel;i++){
			addRandomCritter(this.spawnPoint,currentLevel);
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ALL CRITTERS GENERATED");
		
		while(true){
			LinkedList<Critter> critterList = critterManager.getCrittersList();
			if(critterList.size()==0){
				return;
			}
			for(Critter c:critterList){
				if(c.getPosition().getX() >= endPoint.getX()){
					int newAmmount = (int) (player.getGold()-c.getLevel()*STEAL_RATE);
					if(newAmmount<0){
						player.setGold(0);
					}
					else{
						//Use the makePurchase Method to notify
						player.makePurchase(c.getLevel());
					}
				}
			}
			try {
				Thread.sleep(REFRESH_RATE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private void addRandomCritter(Vector2D position, int level) {
		Critter c;
		int typeOfCritter = (int)Math.round(Math.random()*2);
		switch (typeOfCritter) {
			case 0: c = new NormalCritter(level);
			case 1: c = new FastCritter(level);
			case 2: c = new TankCritter(level);
			default: c = new NormalCritter(level);
		}
		c.setPosition(position);
		critterManager.addCritter(c);
	}

}