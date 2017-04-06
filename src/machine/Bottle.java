package machine;

import java.util.Observable;

public class Bottle extends Observable {
	private double weight;
	private double price;
	private int bottleCount;
	
	public Bottle(){
		price = 2;
	}
	
	public double getWeight(){
		this.weight = Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int getCount(){
		return ++bottleCount;
	}
	
	public void clearCount(){
		bottleCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
