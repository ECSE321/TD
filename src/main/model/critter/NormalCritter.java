package main.model.critter;

import main.model.Vector2D;

//Average Critter

public class NormalCritter extends Critter{
	
	public NormalCritter(int level, Vector2D startPosition) {
		
		super(level,50+(level*10),50+(level*10),50+(level*10),10,startPosition);
		//level,reward,hitPoints,strength,speed,armored
		/*
			reward = 50+(level*10);
			hitPoints = 50+(level*10);
			strength = 50+(level*10);
			speed = 10;
			Armored = false;
		*/
		
	}
		
	
	
}
