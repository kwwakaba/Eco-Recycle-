package machine;

public class Glass {
	private double weight;
	private double price;
	private int glassCount;
	
	public Glass(){
		price = 3.50; 
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++glassCount;
	}
	
	public void clearCount(){
		glassCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
