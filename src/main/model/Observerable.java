package main.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Observerable {
	List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers(String arg) {
		for(Observer o: observers) {
			o.update(this, arg);
		}
	}
}
