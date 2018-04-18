package task_3;

import java.util.ArrayList;

public class Bouquet {
	private ArrayList<Flower> dbFlower;
	private int price;
	
	public Bouquet() {
		dbFlower = new ArrayList<Flower>();
		price = 0;
	}
	
	public void addFlower(Flower newFlower) {
		dbFlower.add(newFlower);
		price += newFlower.getPrice();
	}
	
	public Flower[] getFowers() {
		Flower[] arrayFlower = new Flower[dbFlower.size()];
		arrayFlower = dbFlower.toArray(arrayFlower);
		return arrayFlower;
	}
	
	public int getPrice() {
		return price;
	}
}
