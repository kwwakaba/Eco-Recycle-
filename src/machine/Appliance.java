package machine;

public class Appliance {
	private double weight;
	private double price;
	private int applianceCount;
	
	public Appliance(){
		price = 5.50;
	}
	
	public double getWeight(){
		this.weight =  Math.random()*10;
		return this.weight;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public int getCount(){
		return ++applianceCount;
	}
	
	public void clearCount(){
		applianceCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
