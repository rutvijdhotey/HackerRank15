package dpHackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class Abbreviation {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		
		int numberOfTests = in.nextInt();
		in.nextLine();
		String[] array = new String[2*numberOfTests];
		for(int i = 0; i < array.length ; i++){
			array[i] = in.nextLine();
		}
		
		in.close();
		
		for(int i = 0 ; i < array.length - 1; i++){
			String a = array[i];
			String b = array[i+1];
			
			System.out.println(canWeAbbrev(a,b));
			i++;
		}
		

	}

	private static String canWeAbbrev(String a, String b) {
		if(a.length() < b.length()){
			return "NO";
		}
		
		Boolean canWe = true;
		String answer = "YES";
		
		String main = a;
		String compareTo = b;
		
		int checkFrom = 0;
		for(int i = 0 ; i< compareTo.length(); i++){
			if(!canWe){
				break;
			}
			for(int j = checkFrom ; j < main.length(); j++){
				if(compareTo.charAt(i) == main.charAt(j) || compareTo.charAt(i) == main.toUpperCase().charAt(i)){
					checkFrom = j;
					canWe = true;
					break;
				}
				if(main.charAt(i) == main.toUpperCase().charAt(i)){
					canWe = false;
					break;
				}
				canWe = false;
			}
		}
		
		if(!canWe){
			answer = "NO";
		}
		
		return answer;
	}

}
