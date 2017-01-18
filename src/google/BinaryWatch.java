package google;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static List<String> readBinaryWatch(int num){
		List<String> result = new ArrayList<String>();
		for(int i = 0 ; i< 12; i++){
			for(int j = 0; j < 60 ; j++){
				if(Integer.bitCount(i) + Integer.bitCount(j) == num){
					result.add(String.format("%d:%02d", i,j));
				}
			}
		}
		
		return result;
	}
}
