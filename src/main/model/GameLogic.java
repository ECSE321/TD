package main.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
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
	private List<View> views;
	private Vector2D endPoint;
	private AttackThread attack_thread;
	private CritterMonitor critter_thread;
	
	double STEAL_RATE = 0.00001;
	boolean init = true;
	
	int previousPlayerMoney = 0;
	
	
	public GameLogic(Map m) {
		critterManager = new CritterManager();
		towerManager = new TowerManager();
		player = new Player();
		map = m;
		spawnPoint = map.getFirstTile().getCenterDrawPosition();
		views = new ArrayList<View>();
		endPoint = map.getLastTile().getPosition();
		attack_thread = new AttackThread(critterManager,towerManager,player);
		critter_thread = new CritterMonitor(critterManager,player,map);
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
		LinkedList<Critter> critters = critterManager.getCrittersList();
		for (Critter c : critters) {
				Tile tile = map.getTileAt(c.getPosition());
				Tile nextTile = ((Path)tile).getNext();
				if(nextTile==null){
					int newAmmount = (int) (player.getGold()-c.getLevel());
					if(newAmmount<0){
						player.setGold(0);
					}
					else{
						//Use the makePurchase Method to notify
						player.makePurchase(c.getLevel());
					}
					critterManager.removeCritter(c);
					continue;
				}
				Vector2D nextTileVector = new Vector2D (nextTile.getCenterDrawPosition().getX()+13, nextTile.getCenterDrawPosition().getY()+13);
				Vector2D directionVector = nextTileVector.getDisplacementVector(c.getPosition());
				Vector2D velocityVector = directionVector.getNormalizedVector().getScalarMultipleVector(c.getSpeed()/6);
				Vector2D newPosition = c.getPosition().getVectorAddition(velocityVector); 
				c.setPosition(newPosition);
				//System.out.println(c.getPosition().getX() + " , " + c.getPosition().getY() + " health: " + c.getHitPoints());
		}
	}
	
	private int crittersToSpawn;
	private int spawnCounter = 50;
	private void spawnCritters() {
		if(crittersToSpawn > 0) {
			if(spawnCounter == 0) {
				addRandomCritter(spawnPoint, player.getLevel());
				crittersToSpawn--;
				spawnCounter = 50;
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
	
	private boolean areAllCrittersDead(){
		LinkedList<Critter> critterList = critterManager.getCrittersList();
		if(critterList.size()==0){
			return true;
		}
		return false;
	}

	private boolean isPlayerDead(){
		if(player.getGold() <= 0){
			return true;
		}
		return false;
	}

	
	public void updateFrame() {
		if(init){
			previousPlayerMoney = player.getGold();
			if(player.getLevel()==1){
				critter_thread.start();
				attack_thread.start();
			}
			else{
				critter_thread = new CritterMonitor(critterManager,player,map);
				attack_thread = new AttackThread(critterManager, towerManager, player);
				critter_thread.start();
				attack_thread.start();
			}
			init = false;
		}
		
		if(previousPlayerMoney != player.getGold()){
			updateViews();
			previousPlayerMoney = player.getGold();
		}
		
		else if(isPlayerDead()){
			//TODO: deal with game over
			updateViews();
		}
		else if(areAllCrittersDead()&&!critter_thread.isAlive()){
			player.setLevel(player.getLevel()+1);
			updateViews();
			//TODO: Wait for click
			init = true;
		}
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
		updateViews();
	}
	
	public void sellTower() {
		Tower t = map.getSelectedTile().getTower();
		player.addGold(t.getRefundValue());
		towerManager.removeTower(t);
		map.getSelectedTile().removeTower(t);
		updateViews();
	}
	
	public void upgradeTower() {
		Tower t = map.getSelectedTile().getTower();
		player.makePurchase(t.getUpgradeCost());
		t.upgrade();
		updateViews();
	}
	
	public void startWave() {
		crittersToSpawn = player.getLevel() * 2;
	}
	
	public Tile getSelectedTile() {
		return map.getSelectedTile();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addView(View view) {
		views.add(view);
	}
	
	public void updateViews() {
		for (View v: views) {
			v.update();
		}
	}
}
