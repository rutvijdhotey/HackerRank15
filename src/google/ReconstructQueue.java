package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {

	
	public static int[][] reconQ(int[][] people){
		Arrays.sort(people,new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				return a[0] != b[0] ? -a[0] + b[0] : a[1] - b[1]; 
			}
		});
	
		List<int[]> list = new LinkedList<>();
		for(int[] person: people){
			list.add(person[1],person);
		}
		
	
		return list.toArray(new int[people.length][2]);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
