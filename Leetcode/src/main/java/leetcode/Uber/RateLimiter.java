package leetcode.Uber;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by cc on 2017/6/12.
 */

public class RateLimiter {

    AtomicLong nextRefillTime = new AtomicLong(0);
    AtomicLong size = new AtomicLong(0);
    long capacity;
    long refillInterval;

    public RateLimiter(long capacity, long refillInterval){
        this.capacity = capacity;
        this.refillInterval = refillInterval;
    }


    public boolean consume(int i){
        //every consume, we try to refill
        refill();
        if(i < size.get()) return false;
        size.set(size.get()-i);
        return true;
    }

    //only refill when pass the next refill time.
    public void refill(){
        long now = System.currentTimeMillis();
        if(now >= nextRefillTime.get()){
            size.set(capacity);
            nextRefillTime.set(now+refillInterval);
        }
    }


}
