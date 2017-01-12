package linkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	static class Interval{
		int start;
		int end;
		
		Interval(int[] interval){
			start = interval[0];
			end = interval[1];
		}
		
		Interval(int i , int j){
			start =i;
			end = j;
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
		
		int[] interval1 = {2,5};
		Interval n = new Interval(interval1);
		testList.add(n);
		int[] interval2 = {7,9};
		n = new Interval(interval2);
		testList.add(n);
		int[] interval3 = {13,14};
		n = new Interval(interval3);
		testList.add(n);
		int[] interval4 = {15,22};
		n = new Interval(interval4);
		testList.add(n);
		int[] newinterval = {4,20};
		n = new Interval(newinterval);
		//testList.add(n);
		
		List<Interval> ans = insert(testList,n);
		
		
	}
	
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
	        result.add(intervals.get(i++));
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval( // we could mutate newInterval here also
	                Math.min(newInterval.start, intervals.get(i).start),
	                Math.max(newInterval.end, intervals.get(i).end));
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
	}
}
