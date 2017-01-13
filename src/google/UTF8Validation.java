package google;

public class UTF8Validation {

	public static boolean Utf8Validation(int[] array){
		if(array.length == 0) return true;
		int skip = 0b10000000;
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(count > 0){
				if((array[i] & 0b11000000) == skip ){
					count--;
				} else {
					return false;
				}
			} else {
				count = getCount(array[i]);
				if(count < 0){
					return false;
				}
			}
		}
		
		return count == 0;
	} 
	
	public static int getCount(int x){
		if((x & 0b11110000) == 0b11110000) return 3;
		else if ((x & 0b11100000) == 0b11100000) return 2;
		else if ((x & 0b11000000) == 0b11000000) return 1;
		else if ((x & 0b10000000) == 0b10000000) return -1;
		else {
			return 0;
		}
	}
}
