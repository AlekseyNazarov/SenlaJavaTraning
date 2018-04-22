package task_1;

import java.util.Random;

public class RandomArrayString {
	public static String[] getArrayString(int count, int limit) {
		count = Math.abs(count);
		limit = Math.abs(limit);
		Random random = new Random();
	    String arr[] = new String[count];
	    for(int i = 0; i < arr.length; i++){
	        arr[i] = String.valueOf(random.nextInt(limit));
	    }
	    return arr;
	}	
}
