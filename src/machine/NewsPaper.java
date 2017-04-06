package machine;

public class NewsPaper {
	private double weight;
	private double price;
	private int npCount;
	
	public NewsPaper(){
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
		return ++npCount;
	}
	
	public void clearCount(){
		npCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
