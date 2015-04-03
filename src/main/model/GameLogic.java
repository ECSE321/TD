package main.model;

import main.model.map.*;
import main.model.tower.*;
import main.model.critter.*;

public class GameLogic {
	private CritterManager critterManager;
	private TowerManager towerManager;
	private Player player;
	private Map map;
	private Tile selectedTile;
	
	public GameLogic(CritterManager cm, TowerManager tm, Player p, Map m) {
		
	}
	
	public boolean purchaseTower(int towerType) {
		Tower tower;
		if(selectedTile == null) return false;
		
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
			default: return false;
		}
		int cost = tower.getBuyingCost();
		if(!player.makePurchase(cost)) return false;
		
		towerManager.addTower(tower);
		selectedTile.addTower(tower);
		return true;
	}
	
	public boolean sellTower() {
		Tower tower = selectedTile.getTower();
		if(tower == null) {
			return false;
		} else {
			int refund = tower.getRefundValue();
			player.addGold(refund);
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
		selectedTile = map.getTileAt(v);
	}
	
	public boolean purchaseHealth() {
		if(player.getGold() < 100) {
			return false;
		} else {
			player.setHealth(player.getHealth() + 10);
			return true;
		}
	}
}
