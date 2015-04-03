package main.model.critter;
import java.util.LinkedList;

public class critterManager {

	private LinkedList<Critter> critters;
	
	public critterManager() {
		critters = new LinkedList<Critter>();
	}
	
	public void addCritter(Critter critterToAdd){
		critters.add(critterToAdd);
	}

}
