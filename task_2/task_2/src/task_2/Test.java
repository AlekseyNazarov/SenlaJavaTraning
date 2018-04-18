package task_2;

import java.util.Random;

public class Test {
	public static void main(String args[]) {
		Random random = new Random();
		int tmp = 100 + random.nextInt(900);
		System.out.printf("Number: %d; Sum digits: %d", tmp, sumDigitsNumber(tmp));
	}
	
	public static int sumDigitsNumber(int number) {
		if (number == 0) {
			return 0;
		}
		return number % 10 + sumDigitsNumber(number / 10);
	}
}
