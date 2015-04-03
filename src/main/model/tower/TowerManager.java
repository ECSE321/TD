package main.model.tower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;




public class TowerManager {

	private List<Tower> towers = new ArrayList<Tower>();
	

   public TowerManager() {
	   towers = new LinkedList<Tower>();
	
   }

   public void addTower(Tower t) {
		towers.add(t);
	}
	
	public void removeTower(Tower t) {
		towers.remove(t);
	}
	
	public Tower getTower(Tower t){
		
		int index = towers.indexOf(t);
						
		return towers.get(index);
		
		
	}
	
}
