package main;

import java.util.List;

import main.model.*;
import main.model.critter.*;
import main.model.tower.*;

public class Printer extends Thread{

	private CritterManager cm;
	
	public Printer(CritterManager cm) {
		this.cm=cm;
	}
	
	public void run(){
		while(true){
			List<Critter> critterList = cm.getCrittersList();
			for(Critter currentCritter:critterList){
				System.out.println("Strength: " + currentCritter.getStrength() + " Health: " + currentCritter.getHitPoints() + " X position: " + currentCritter.getPosition().getX());
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
