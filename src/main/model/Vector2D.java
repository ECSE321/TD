package main.model;

public class Vector2D {
	private int x;
	private int y;
	
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getMagnitude(){
		return Math.sqrt( Math.pow(this.x, 2) + Math.pow(this.y, 2) );
	}
	
	public Vector2D getDisplacementVector(Vector2D v) {
		int x = this.x - v.getX();
		int y = this.y - v.getY();
		return new Vector2D(x,y);
	}
	
	public Vector2D getScalarMultipleVector(int n) {
		int x = this.x * n;
		int y = this.y * n;
		return new Vector2D(x,y);
	}
	
	public Vector2D getNormalizedVector() {
		double magnitudeV = Math.sqrt( Math.pow(this.x, 2) + Math.pow(this.y, 2) );
		int x = (int)Math.round(this.x / magnitudeV);
		int y = (int)Math.round(this.y / magnitudeV);
		return new Vector2D(x, y);
	}
	
}
