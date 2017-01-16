package google;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{
	private Integer next = null;
	private Iterator<Integer> iter;
	
	public PeekingIterator(Iterator<Integer> iter){
		if(iter.hasNext()){
			next = iter.next();
		}
	}
	
	@Override
	public Integer next(){
		int res = next;
		if(iter.hasNext()){
			next = iter.next();
		} else {
			next = null;
		}
		
		return res;
		
	}
	
	@Override
	public boolean hasNext(){
		if(next == null){
			return false;
		}
		return true;
	}
	
	public Integer peek(){
		return next;
	}
	

}
