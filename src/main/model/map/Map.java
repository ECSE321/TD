package main.model.map;

import java.util.ArrayList;
import java.util.List;

import main.model.Vector2D;

public class Map {
	private List<Tile> tiles;
	private int id;
	
	public void addTile(Tile t) {
		tiles.add(t);
	}
	
	public Map() {
		this.tiles = new ArrayList<Tile>();
	}
	
	public int getId() {
		return id;
	}
	
	public Tile getTileAt(Vector2D v) {
		for(Tile t : tiles) {
			if(t.isHere(v)) return t;
		}
		return null;
	}
	
	public List<Tile> getTilesList() {
		return tiles;
	}
}
