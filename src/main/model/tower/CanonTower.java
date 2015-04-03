package main.model.tower;

import main.model.Vector2D;

/**
 * @author Luis Gallet Zambrano
 * 
 */
public class CanonTower extends Tower {
    
	//Each subclass has a different cost and it should not be modified
	
	private int UpgradeCost = 1200;
	
	
	
	public CanonTower(Vector2D position) {
		
		//Level 1 characteristics of the CanonTower
		
		super(20,100,50,3,200,1, position);
		//range,refund value, power, rate of fire, buying cost, level
	}

	

	public boolean upgrade(int coins) {
	
		if (super.upgrade(coins, getLevel(), UpgradeCost))
	{
		return true;
		
    }
	
	return false;
	
	}



	
}

