package leetcode.Linkedin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2017/7/13.
 */
public class ZigZagIterator {

    /**
     * Idea is maintain a list of iterators in sequence.
     * every time just poll the first from list,
     * take the value.
     * if the iterator still has next, then append to the end.
     * */
    List<Iterator> its;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        its = new LinkedList<>();
        if(!v1.isEmpty()) its.add(v1.iterator());
        if(!v2.isEmpty()) its.add(v2.iterator());
    }

    public int next() {
        //get the first iterator, return the next value.
        //if iterator still has next, append to the end of the iterator list.
        Iterator<Integer> first = its.remove(0);
        int result = first.next();
        if(first.hasNext()) its.add(first);
        return result;
    }

    public boolean hasNext() {
        return !its.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(1, 2, 3);
        List<Integer> test1 = Arrays.asList(4,5,6,7,8);
        ZigZagIterator zzi = new ZigZagIterator(test, test1);
        while(zzi.hasNext())
            System.out.println(zzi.next());
    }

}
