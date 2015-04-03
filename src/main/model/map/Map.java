package main.model.map;

import java.util.ArrayList;
import java.util.List;

import main.model.Vector2D;

public class Map {
	private List<Tile> tiles;
	private int id;
	
	public Map(int id) {
		this.tiles = new ArrayList<Tile>();
		this.id = id;
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
}
