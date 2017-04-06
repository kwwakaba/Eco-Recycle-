package machine;

public class LightBulb {
	private double weight;
	private double price;
	private int lbCount;
	
	public LightBulb(){
		price = 2.00;
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++lbCount;
	}
	
	public void clearCount(){
		lbCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
