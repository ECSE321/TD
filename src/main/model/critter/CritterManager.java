package main.model.critter;
import java.util.LinkedList;

public class CritterManager {

	private LinkedList<Critter> critters;
	
	public CritterManager() {
		critters = new LinkedList<Critter>();
	}
	
	public void addCritter(Critter critterToAdd){
		critters.add(critterToAdd);
	}

}
