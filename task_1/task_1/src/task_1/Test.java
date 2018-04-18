package task_1;

import java.util.Random;

public class Test {
	public static void main(String args[]){
        Random random = new Random();
        String arr[] = new String[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = String.valueOf(random.nextInt(1000));
        }
        System.out.println(sumElementsString(arr));
    }
	
	public static String sumElementsString(String arr[]){
        long sum = 0;
        try{
            for(String str : arr){
                sum += Long.valueOf(str);
            }
            return String.valueOf(sum);
        }
        catch(Exception ex){    
        	return null;
        }
    }
}
