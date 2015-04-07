package main.model;


import main.model.critter.*;
import main.model.map.Map;

public class CritterGenerator extends Thread {
	
	private CritterManager critterManager;
	private Player player;
	private Map map;
	
	Vector2D spawnPoint;
	
	//Constant
	private int DELAY = 1500; //Delay between each new Critter in ms
	//private int REFRESH_RATE = 500; //Delay between each check for critter at end
	//private double STEAL_RATE = 0.00001;
	
	public CritterGenerator(CritterManager cm, Player p, Map m) {
		this.critterManager = cm;
		this.player = p;
		this.map = m;
		this.spawnPoint = map.getFirstTile().getCenterDrawPosition();
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
		
		return;
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