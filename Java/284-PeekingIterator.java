// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer next = null;
    boolean finished = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    if (iterator.hasNext()) next = iterator.next();
	    else{
	        next = null;
	        finished = true;
	    }    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer cached = next;
	    if (iterator.hasNext()) 
	        next = iterator.next();
	    else    {
	        next = null;
	        finished = true;
	    }
	    return cached;
	}

	@Override
	public boolean hasNext() {
	    return !finished;
	}
}