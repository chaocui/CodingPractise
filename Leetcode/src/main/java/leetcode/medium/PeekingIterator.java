package leetcode.medium;

import java.util.Iterator;

/**
 * Created by cc on 2016/8/7.
 */
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> it = null;
    boolean peeked = false;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!peeked){
            next = this.it.next();
            peeked = true;
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!peeked){
            next = this.it.next();
        }
        else{
            //Reset peeked, since next is called, meaning move to next.
            peeked = false;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        if(peeked){
            return true;
        }
        else{
            return this.it.hasNext();
        }
    }
}
