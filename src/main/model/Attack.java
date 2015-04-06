package main.model;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import main.model.critter.Critter;
import main.model.critter.CritterManager;
import main.model.tower.Tower;
import main.model.tower.TowerManager;

public class Attack extends Thread {
	private CritterManager critterManager;
	private TowerManager towerManager;
	private Player player;



	public void run(CritterManager cm, TowerManager tm, Player p) {
		//Keep track of managers
		this.critterManager = cm;
		this.towerManager = tm;
		this.player = p;
		//This will tick every time the towers are checked
		int tick =0;

		//Keep track of the towers
		List<Tower> towerList = null;
		List<Critter> critterList = null;
		Hashtable<Tower,List<Critter>> aimed = new Hashtable<Tower,List<Critter>>();
		//Iterators:
		Iterator<Tower> towerIterator = null;



		//this thread will run during each level
		while(true){
			//Get the lists of towers and critters
			if(!towerList.equals(towerManager.getTowersList())){
				towerList = towerManager.getTowersList();
				for(Tower currentTower:towerList){
					//Traverse the list of towers, add the tower to the hashtable if it isn't in it already.
					if(!aimed.containsKey(currentTower)){
						aimed.put(currentTower,null);
					}
				}	
			}
			critterList = critterManager.getCrittersList();

			for(Tower currentTower:towerList){
				Vector2D towerPosition = currentTower.getPosition();
				for(Critter currentCritter:critterList){
					Vector2D critterPosition = currentCritter.getPosition();
					//Compute the displacement between the tower and the critter:
					Vector2D displacement = towerPosition.getDisplacementVector(critterPosition);
					//Add to the list if a critter is found to be in range
					if(displacement.getMagnitude()<currentTower.getRange()){
						if(!aimed.get(currentTower).contains(currentCritter)){
							List<Critter> towerCritters = aimed.get(currentTower);
							towerCritters.add(currentCritter);
							aimed.replace(currentTower, towerCritters);
						}
					}

				}
			}

			for(Tower currentTower:towerList){
				//If the tower has had time to "reload"
				if(tick%currentTower.getRateOfFire()==0){
					Vector2D towerPosition = currentTower.getPosition();
					//Get the list of critters seen by the tower
					List<Critter> towerCritters = aimed.get(currentTower);
					for(Critter currentCritter:towerCritters){
						Vector2D critterPosition = currentCritter.getPosition();
						//Compute the displacement between the tower and the critter:
						Vector2D displacement = towerPosition.getDisplacementVector(critterPosition);
						//If the critter is in range and not dead
						if(displacement.getMagnitude()<currentTower.getRange() && currentCritter.getHitPoints()>0){
							//Notify Observers
							int currHP = currentCritter.takeDamage();
							//Compute the new health of the critter
							currHP -= computeDamage(currentTower,currentCritter);
							currentCritter.setHitPoints(currHP);
							//TODO: what if the critter is dead.
						}
					}	
				}

			}

			//Make the thread sleep for a while before checking again
			tick++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int computeDamage(Tower t, Critter c){
		//TODO: implement better damage computation
		return t.getPower()/c.getStrength();
	}
}
