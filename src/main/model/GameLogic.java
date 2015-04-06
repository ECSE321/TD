package main.model;

import java.awt.Point;
import java.util.List;

import main.model.map.*;
import main.model.tower.*;
import main.model.critter.*;

public class GameLogic {
	private CritterManager critterManager;
	private TowerManager towerManager;
	private Player player;
	private Map map;
	private Vector2D spawnPoint;
	
	
	public GameLogic(Map m) {
		critterManager = new CritterManager();
		towerManager = new TowerManager();
		player = new Player();
		map = m;
		spawnPoint = map.getFirstTile().getCenterDrawPosition();
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
	
	private void moveCritter() {
		List<Critter> critters = critterManager.getCrittersList();
		for (Critter c : critters) {
				Tile tile = map.getTileAt(c.getPosition());
				Tile nextTile = ((Path)tile).getNext();
				Vector2D nextTileVector = new Vector2D (nextTile.getCenterDrawPosition().getX(), nextTile.getCenterDrawPosition().getY());
				Vector2D directionVector = nextTileVector.getDisplacementVector(c.getPosition());
				Vector2D velocityVector = directionVector.getNormalizedVector().getScalarMultipleVector(c.getSpeed()/10);
				Vector2D newPosition = c.getPosition().getVectorAddition(velocityVector); 
				c.setPosition(newPosition);
				System.out.println(c.getPosition().getX() + " , " + c.getPosition().getY());
		}
	}
	
	private int crittersToSpawn;
	private int spawnCounter = 3;
	private void spawnCritters() {
		if(crittersToSpawn > 0) {
			if(spawnCounter == 0) {
				addRandomCritter(spawnPoint, player.getLevel());
				crittersToSpawn--;
				spawnCounter = 3;
			} else {
				spawnCounter--;
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
	
	public void updateFrame() {
		spawnCritters();
		moveCritter();
		
	}
	
	/*
	 * Button actions
	 */
	public void selectTile(Point p) {
		Vector2D v = new Vector2D(p.x, p.y);
		System.out.println(v.getX() + " , " + v.getY());
		map.selectTile(v);
		System.out.println(map.getSelectedTile().getPosition().getX() + " , " + map.getSelectedTile().getPosition().getY());
	}
	
	public void purchaseTower(int towerType) {
		Tower t;
		Vector2D position = map.getSelectedTile().getCenterDrawPosition();
		System.out.println(position.getX() + " , " + position.getY());
		switch(towerType) {
			case 0: t = new CanonTower(position);
			case 1: t = new MachineGunTower(position);
			case 2: t = new MortarTower(position);
			case 3: t = new SpellTower(position);
			default: t = new CanonTower(position);
		}
		towerManager.addTower(t);
		map.getSelectedTile().addTower(t);
		int cost = t.getBuyingCost();
		player.makePurchase(cost);
	}
	
	public void sellTower() {
		Tower t = map.getSelectedTile().getTower();
		player.addGold(t.getRefundValue());
		towerManager.removeTower(t);
		map.getSelectedTile().removeTower(t);
	}
	
	public void upgradeTower() {
		Tower t = map.getSelectedTile().getTower();
		player.makePurchase(t.getUpgradeCost());
		t.upgrade();
	}
	
	public void startWave() {
		crittersToSpawn = player.getLevel() * 1;
	}
	
	
}
