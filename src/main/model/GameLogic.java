package main.model;

import java.util.List;

import main.model.map.*;
import main.model.tower.*;
import main.model.critter.*;

public class GameLogic {
	private CritterManager critterManager;
	private TowerManager towerManager;
	private Player player;
	private Map map;
	
	public GameLogic(Map m) {
		critterManager = new CritterManager();
		towerManager = new TowerManager();
		player = new Player();
		map = m;
	}
	
	public List<Critter> getCrittersList() {
		return critterManager.getCrittersList();
	}
	
	public List<Tower> getTowersList() {
		return towerManager.getTowersList();
	}
	
	public List<Tile> getTilesList() {
		return map.getTilesList();
	}
	
	public void addCritter() {
		critterManager.addCritter(new NormalCritter(1));
		critterManager.getCrittersList().get(0).setPosition(new Vector2D(10,10));
	}
	
	public void updateFrame() {
		Vector2D newPosition = new Vector2D(critterManager.getCrittersList().get(0).getPosition().getX() + 2, critterManager.getCrittersList().get(0).getPosition().getY());
		critterManager.getCrittersList().get(0).setPosition(newPosition);
	}
}
