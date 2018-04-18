package task_3;

import java.util.Random;

public class Test {
	public static void main(String args[]) {
		Bouquet bouquet = new Bouquet();
		Random random = new Random();
		int tmp;
		int countFlowers = random.nextInt(10);
		
		for(int i = 0; i < countFlowers; i++) {
			tmp = random.nextInt(4);
			switch (tmp) {
			case 0:
				bouquet.addFlower(new Rose());
				break;
			case 1:
				bouquet.addFlower(new Lily());
				break;
			case 2:
				bouquet.addFlower(new Iris());
				break;
			case 3: 
				bouquet.addFlower(new Carnation());
				break;
			}
		}
		
		Flower[] flowersInBouquet = bouquet.getFowers();
		System.out.print("Bouquet: [ ");
		for(Flower fl : flowersInBouquet) {
			System.out.print(fl.getName() + " ");
		}
		System.out.printf("]\nPrice: %d", bouquet.getPrice());
		
	}
}
