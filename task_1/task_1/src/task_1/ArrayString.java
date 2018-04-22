package task_1;

public class ArrayString {
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
