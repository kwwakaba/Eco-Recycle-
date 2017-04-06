package machine;

public class Book {
	private double weight;
	private double price;
	private int bookCount;
	
	public Book(){
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
		return ++bookCount;
	}
	
	public void clearCount(){
		bookCount = 0;
	}
	
	public void setPrice(double newPrice){
		this.price = newPrice;
	}
}
