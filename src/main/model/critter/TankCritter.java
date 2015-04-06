package main.model.critter;

import main.model.Vector2D;

public class TankCritter extends Critter{

	public TankCritter(int level, Vector2D startPosition) {
		
		super(level,50+(level*20),50+(level*20),50+(level*20),5,startPosition);
		
		/*
			reward = 50+(level*20);
			hitPoints = 50+(level*20);
			strength = 50+(level*20);
			speed = 5;
			armored = true;
		*/
	}

}
