package linkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	static class Interval{
		int start;
		int end;
		
		Interval(int[] interval){
			start = interval[0];
			end = interval[1];
		}
	}
	
	
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> answerList = new ArrayList<Interval>();
		
		if(intervals.size() == 0){
			return  answerList;
		}
		
		//Custom Comparator to sort the intervals wrt starttime
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval one, Interval two){
				 if (one.start > two.start ){
					   return 1;
				 } else if (one.start < two.start){
					   return -1;
		    	 } else {
					   return 0;
				 }
			}
		});
		
		
		Interval currentInterval = intervals.get(0);
		//answerList.add(currentInterval);
		for (int i = 1; i < intervals.size() ; i++){
			Interval newInterval = intervals.get(i);
			if(newInterval.start <= currentInterval.end){
				currentInterval.end = Math.max(newInterval.end, currentInterval.end);
			} else {
				answerList.add(currentInterval);
				currentInterval = newInterval;
			}
		}
		
		answerList.add(currentInterval);
		
		return answerList;
    }
	
	public static void main(String args[]){
		
		
		
		List<Interval> testList= new ArrayList<Interval>();
		
		int[] interval1 = {1,3};
		Interval n = new Interval(interval1);
		testList.add(n);
		int[] interval2 = {8,10};
		n = new Interval(interval2);
		testList.add(n);
		int[] interval3 = {2,6};
		n = new Interval(interval3);
		testList.add(n);
		int[] interval4 = {15,18};
		n = new Interval(interval4);
		testList.add(n);
		int[] interval5 = {3,8};
		n = new Interval(interval5);
		testList.add(n);
		int[] interval6 = {21,29};
		n = new Interval(interval6);
		testList.add(n);
		
		List<Interval> ans = merge(testList);
		
		
	}
}
