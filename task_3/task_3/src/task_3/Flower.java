package task_3;

public abstract class Flower {
	private String name;
	private int price;
	
	public Flower(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}
