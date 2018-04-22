package task_2;

public class Number {
	public static int sumDigitsNumber(int number) {
		if (number == 0) {
			return 0;
		}
		return number % 10 + sumDigitsNumber(number / 10);
	}
}
