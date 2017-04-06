package machine;

public class Crate{
	private double weight;
	private double price;
	private int crateCount;
	
	public Crate(){
		price = 4.50;
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++crateCount;
	}
	
	public void clearCount(){
		crateCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
