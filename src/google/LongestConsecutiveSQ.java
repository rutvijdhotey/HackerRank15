package google;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestConsecutiveSQ {

		public static int longestSq(int[] array){
			HashSet<Integer> set = new HashSet<>();
			ArrayList<Integer> list = new ArrayList<>();
			for(int num: array) { set.add(num); }
			int maxLen = 0;
			for(int num : array){
				int maxLenLeft = 0;
				int maxLenRight = 1;
				ArrayList<Integer> current = new ArrayList<>();
				if(!set.contains(num)) continue;
				
				//current.add(num);
				if(set.contains(num - 1)){
					int nextNum = num - 1;
					while(set.contains(nextNum)){
						set.remove(nextNum);
						nextNum--;
						maxLenLeft++;
						//current.add(0, nextNum);
					}
				}
				
				if(set.contains(num + 1)) {
					int nextNum = num + 1;
					while(set.contains(nextNum)){
						set.remove(nextNum);
						nextNum++;
						maxLenRight++;
						//current.add(1,nextNum);
					}
				}
				set.remove(num);
				maxLen = Math.max(maxLenLeft + maxLenRight, maxLen);
			}
			
			return maxLen;
			
		}
		
		public static void main(String[] args) {
			int[] array = {100,4,200,1,3,2,-1,5,6,0};
			int ans = longestSq(array);
			
		}
}
