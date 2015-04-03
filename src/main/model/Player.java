package main.model;

public class Player {
	private int health;
	private int gold;
	private int level;
	
	public Player(int health, int gold, int level) {
		this.health = health;
		this.gold = gold;
		this.level = level;
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
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public boolean makePurchase(int gold) {
		if(this.gold < gold) {
			return false;
		} else {
			this.gold -= gold;
			return true;
		}
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}
}
