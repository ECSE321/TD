package main.model.map;

import main.model.Vector2D;
import main.model.tower.Tower;

public abstract class Tile {
	Vector2D position;
	Tower tower;
	int size = 10;
	
	public Tile(int x, int y) {
		position = new Vector2D(x,y);
	}
	
	public boolean isPath() {
		if (this instanceof Path) {
			return true;
		} else {
			return false;
		}
	}
	
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
