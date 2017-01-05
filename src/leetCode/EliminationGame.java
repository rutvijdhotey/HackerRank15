package leetCode;

import java.util.ArrayList;


public class EliminationGame {
	 public static int lastRemaining(int n) {
	     int number = 0;
	     ArrayList<Integer> list = new ArrayList<>();
	     
	     if(n == 1){
	    	 return 1;
	     }
	     
	     for(int i = 1; i <=n ; i++){
	    	 list.add(i);
	     }
	     
	     
	     int l2r = 0;
	     int r2l = 0;
	     while(list.size() != 1){
	    	 if(list.size() == 1){
	    		 break;
	    	 }
	    	 while(l2r < list.size()){
	    		 list.remove(l2r);
	    		 l2r++;
	    	 }
	    	 
	    	 r2l = list.size()-1;
	    	 if(list.size() == 1){
	    		 break;
	    	 }
	    	 while(r2l >= 0){
	    		 list.remove(r2l);
	    		 r2l -= 2;
	    	 }
	    	 
	    	 l2r = 0;
	    	 
	     }
	     
	     number = list.get(0);
		 return number;
	 }
	 
	 public static void main(String[] args) {
		
		 int n = 14;
		 int ans = lastRemaining(n);
		 System.out.println(ans);
	}
}
