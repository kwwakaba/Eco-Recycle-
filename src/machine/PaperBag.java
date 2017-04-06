package machine;

public class PaperBag{
	private double weight;
	private double price;
	private int pbCount;
	
	public PaperBag(){
		price = 0.50;
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++pbCount;
	}
	
	public void clearCount(){
		pbCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
