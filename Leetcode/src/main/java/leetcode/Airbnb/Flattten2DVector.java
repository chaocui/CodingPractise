package leetcode.Airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cc on 2017/6/17.
 */
public class Flattten2DVector {

    Iterator<List<Integer>> it;
    Iterator<Integer> innerIt;
    int currentOut = 0;
    List<List<Integer>> vec2d;
    public Flattten2DVector(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        it = vec2d.iterator();
        if(it.hasNext())
            innerIt = it.next().iterator();
        else
            innerIt = null;
    }

    public Integer next() {
        if(hasNext())
            return innerIt.next();
        return null;
    }

    public boolean hasNext() {
        if(innerIt == null)
            return false;
        if(innerIt.hasNext())
            return true;
        while(it.hasNext()){
            innerIt = it.next().iterator();
            currentOut++;
            if(innerIt.hasNext())
                break;
        }
        return innerIt.hasNext();
    }

    public void remove(){
        innerIt.remove();
        if(vec2d.get(currentOut).size() == 0){
            it.remove();
            if(it.hasNext())
                innerIt = it.next().iterator();
            else
                innerIt = null;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        ll.add(l1);
        ll.add(l2);
        Flattten2DVector f2v = new Flattten2DVector(ll);
        int i = 0;
        while(f2v.hasNext()){
            System.out.println(f2v.next());
            if(i%2 == 0)
                f2v.remove();
            System.out.println("size:"+ll.size());
            i++;
        }
        System.out.println("size:"+ll.get(0).get(0));
        System.out.println("size:"+ll.get(1).get(1));
    }
}
