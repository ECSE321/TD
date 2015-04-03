package main.model.map;

import main.model.Vector2D;
import main.model.tower.Tower;

public abstract class Tile {
	Vector2D position;
	Tower tower;
	int size = 10;
	
	public Vector2D getPosition() {
		return position;
	}
	
	public Tower getTower() {
		return tower;
	}
	
	public void addTower(Tower tower) {
		this.tower = tower;
	}
	
	public boolean isHere(Vector2D v) {
		if(position.getX() < v.getX()
			&& position.getX() + size > v.getX()
			&& position.getY() < v.getY()
			&& position.getY() + size > v.getY()) {
			return true;
		} else {
			return false;
		}
	}
}
