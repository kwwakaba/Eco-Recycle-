package machine;

public class Can{
	private double weight;
	private double price;
	private int canCount;
	
	public Can(){
		price = 1.00; 
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10; 
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++canCount;
	}
	
	public void clearCount(){
		canCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
