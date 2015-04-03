package main.model.tower;
/**
 * @author Luis Enrique Gallet Zambrano
 *
 */ 
import java.util.ArrayList;
import java.util.List;
import main.model.Vector2D;
 

public abstract class Tower {
    
    protected Vector2D v;

    //Attributes shared by the subclasses
    private int range;
    private int refundValue;
    private int power;
    private int rateOfFire;
    private int buyingCost;
    private int level; 

    
    protected boolean attacked = false;
    protected boolean upgraded = false;
    public int enemmysKilled;
     
     
     
    public Tower(int defaultRange, int defaultRefundValue, int defaultPower, int defaultRateOfFire, int buyingCost, int level, Vector2D position)
    {
        this.setRange(defaultRange);
        this.setRefundValue(defaultRefundValue);
        this.setPower(defaultPower);
        this.setRateOfFire(defaultRateOfFire);
        this.setBuyingCost(buyingCost);
        this.setLevel(level); 
        this.v = position; 
       
         
             
    }
    
   
     
   
     
     
    //Methods shared by the subclasses
     
    /*
     * The upgrade method checks if the User has enough coins to upgrade the Tower.
     * The coins and most of the upgrades are a function of the present tower level, 
     * which starts at 1 by default and increases by one with each call to the method.
    */
    public boolean upgrade(int coins,int level, int cost)
    {
        if(coins >= cost*level){
            if(level < 5){
                setRange(getRange()+50);
                setRefundValue((cost*level)/3);
                setPower(getPower()*(2*level));
                setRateOfFire(getRateOfFire()*(level));
                setLevel(level + 1);
                
                /*
                 * notify observer that tower has upgraded
                 */
                upgraded =true;
                notifyObservers("u");
          
                return true;
            }
 
    }
        return false;
    }
     
    public boolean attack(int critterRange , int critterHealth){
        /*
         * The attack method depends on the critter range compared to the tower location
         *  and on its health. Those attributes are going to be passed on by the critter subclasses.
         *  The logic behind this method is that while the critter is within the Tower range, his health decreases by 
         * the amount of the Tower fire power multiplied by its rate of fire.
        */
         
        int count = 0; //count the amount of "time" to kill a critter.
         
        //notify observer that tower is attacking something
        if(critterRange <= getRange()&& critterHealth > 0){
            attacked = true;
            notifyObservers("a");
             
        }

        while(critterRange <= getRange()&& critterHealth > 0){
            critterHealth = critterHealth - (getPower() * getRateOfFire());
             
            count++;
        }
         
        //System.out.println("time: " + count);
         
     
        if(critterHealth <= 0){
        	enemmysKilled ++;
            return killed();
        }
      

        return false;
     
 
    }
    
    /*
     * the attacked attribute needs to be reset to its default value so it can be used again.
     */
    
    public boolean isBeingAttacked(){
    	
    	if(attacked == true){
    		this.attacked = false;
    		return true;
    	}
        
        return false;
    }
 
    /*
     * the upgraded attribute needs to be reset to its default value so it can be used again.
     */
    
    public boolean hasUpgraded(){
    	if(upgraded == true){
    		this.upgraded = false;
    		return true;
    	}
        
        return false;
    }
     
     /*
      * Amount of critters killed
      */
    public boolean killed(){
        
    	enemmysKilled ++;
        
    	return true;
    }
     
    //Setters and getters to initialize and edit the attributes for each subclass
    public int getRange() {
        return range;
    }
 
    public void setRange(int range) {
        this.range = range;
    }
 
    public int getRefundValue() {
        return refundValue;
    }
 
    public void setRefundValue(int refundValue) {
        this.refundValue = refundValue;
    }
 
    public int getPower() {
        return power;
    }
 
    public void setPower(int power) {
        this.power = power;
    }
 
    public int getRateOfFire() {
        return rateOfFire;
    }
 
    public void setRateOfFire(int rateOfFire) {
        this.rateOfFire = rateOfFire;
    }

	public int getBuyingCost() {
		return buyingCost;
	}

	public void setBuyingCost(int buyingCost) {
		this.buyingCost = buyingCost;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	

 
}
