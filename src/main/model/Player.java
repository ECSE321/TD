package main.model;

public class Player extends Observable{
	private int health;
	private int gold;
	private int level;
	
	public Player() {
		this.health = 100;
		this.gold = 1000;
		this.level = 1;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getGold() {
		return gold;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
		notifyObservers("GoldChange");
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public boolean makePurchase(int gold) {
		if(this.gold < gold) {
			return false;
		} else {
			this.gold -= gold;
			notifyObservers("GoldChange");
			return true;
		}
	}
	
	public void addGold(int gold) {
		notifyObservers("GoldChange");
		this.gold += gold;
	}
}
