package main.model;

public interface IObserver {
	public void update(Observerable o, String arg);
}
