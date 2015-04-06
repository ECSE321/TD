package main.model;


import main.model.critter.*;
import main.model.map_2.Map;

public class CritterGenerator extends Thread {
	
	private CritterManager critterManager;
	private Player player;
	private Map map;
	
	//Constant
	int DELAY = 500; //Delay between each new Critter in ms
	
	public CritterGenerator(CritterManager cm, Player p, Map m) {
		this.critterManager = cm;
		this.player = p;
		this.map = m;
	}
	
	public void run(){
		int currentLevel = player.getLevel();
		Vector2D startPosition = map.getStartPosition();
		//Create 2 critters of each type
		for(int i=0;i<2;i++){
			Critter newNormalCritter = new NormalCritter(currentLevel, startPosition);
			critterManager.addCritter(newNormalCritter);
			Thread.sleep(DELAY);
			Critter newFastCritter = new FastCritter(currentLevel, startPosition);
			critterManager.addCritter(newFastCritter);
			Thread.sleep(DELAY);
			Critter newTankCritter = new TankCritter(currentLevel, startPosition);
			critterManager.addCritter(newTankCritter);
			Thread.sleep(DELAY);
		}
		return;
	}

}
