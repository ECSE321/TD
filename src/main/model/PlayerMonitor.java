package main.model;

import java.util.LinkedList;

import main.model.critter.*;
import main.model.map_2.*;

public class PlayerMonitor extends Thread{

	private CritterManager critterManager;
	private Player player;
	private Map map;
	int endX;
	
	int REFRESH_RATE = 1000; //Refresh every second
	
	public PlayerMonitor(CritterManager cm, Player p, Map m){	
		this.critterManager = cm;
		this.player = p;
		this.map = m;
		endX = map.mapWidth;
	}
	
	public void run(){
		
		if(player.getHealth()<0){
			//TODO: deal with game over
		}
		
		//Check to see which critters have reached the end of the path and update money accordingly
		LinkedList<Critter> critterList = critterManager.getCrittersList();
		for(Critter currentCritter:critterList){
			if(currentCritter.getPosition().getX()==endX){
				if(player.getGold()>currentCritter.getLevel()){
					player.setGold(0);
				}
				else{
					player.makePurchase(currentCritter.getLevel());
				}
			}
		}
		
		
		//Sleep
		try {
			Thread.sleep(REFRESH_RATE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
