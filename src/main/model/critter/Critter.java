package main.model.critter;
import main.model.Vector2D;


public abstract class Critter {

	private Vector2D position;
	
	private int level;
	private int reward;
	private int hitPoints;
	private int strength;
	private int speed;
	private boolean armoured;

	public Critter(int level,int reward, int hitPoints, int strength, int speed, boolean armoured){
		this.setLevel(level);
		this.setReward(reward);
		this.setHitPoints(hitPoints);
		this.setStrength(strength);
		this.setSpeed(speed);
		this.setArmored(armoured);
	}
	
	void move(){
		//TODO: implement move
	}
	
	void takeDamage(int enemyStrength, boolean antiArmour, boolean slow) {
		if(this.getArmored()) {
			if(!antiArmour) {
				int currentHP=getHitPoints();
				this.setHitPoints(currentHP-enemyStrength/2);
			}
		} 
		else {
			int currentHP=getHitPoints();
			this.setHitPoints(currentHP-enemyStrength);
		}
		
		if(slow) {
			int currentSpeed = this.getSpeed();
			this.setSpeed(currentSpeed/2);
		}
	}
	
	public int stealCoins(){
		return this.getStrength()*10;
	}
	
	
	
	public Vector2D getPosition(){
		return this.position;
	}
	
	public void setPosition(Vector2D position){
		this.position = position;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	public int getLevel(){
		return this.level;
	}
	
	public void setReward(int reward){
		this.reward = reward;
	}
	public int getReward(){
		return this.reward;
	}
	
	public void setHitPoints(int hitPoints){
		this.hitPoints = hitPoints;
	}
	public int getHitPoints(){
		return this.hitPoints;
	}
	
	public void setStrength(int strength){
		this.strength = strength;
	}
	public int getStrength(){
		return this.strength;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public int getSpeed(){
		return this.speed;
	}
	
	public void setArmored(boolean armoured){
		this.armoured = armoured;
	}
	public boolean getArmored(){
		return armoured;
	}
}