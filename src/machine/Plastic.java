package machine;

public class Plastic {
	private double weight;
	private double price;
	private int plasticCount;
	
	public Plastic(){
		price = 2.50;
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++plasticCount;
	}
	
	public void clearCount(){
		plasticCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
