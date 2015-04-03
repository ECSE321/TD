package main.model;

import main.model.tower.*;
import main.model.critter.*;

public class GameLogic {
	private CritterManager critterManager;
	private TowerManager towerManager;
	private Player player;
	private Tile selectedTile;
	
	public void purchaseTower(int towerType) {
		//TODO: update tower types when they get created
		Tower tower;
		Vector2D position = selectedTile.getPosition();
		
		switch(towerType) {
			case 1:	tower = new CanonTower(position);
					break;
			case 2: tower = new MachineGunTower(position);
					break;
			case 3: tower = new MortarTower(position);
					break;
			case 4: tower = new SpellTower(position);
					break;
		}
		towerManager.addTower(tower);
		selectedTile.addTower(tower);
	}
	
	public boolean sellTower() {
		Tower tower = selectedTile.getTower();
		if(tower == null) {
			return false;
		} else {
			int refund = tower.getRefundValue();
			player.setGold(player.getGold() + refund);
			towerManager.removeTower(tower);
			return true;
		}
	}
	
	public boolean upgrade() {
		Tower tower = selectedTile.getTower();
		if(tower == null) {
			return false;
		} else {
			int upgradeCost = tower.getUpgradeCost();
			if(upgradeCost > player.getGold() && tower.getLevel() < 5) {
				return false;
			} else {
				tower.upgrade();
				return true;
			}
		}
	}
	
	public void selectTile(Vector2D v) {
		selectedTile.setTile(map.getTileAt(v));
	}
}
