package TwoSigma;

import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by cc on 2016/8/14.
 */
public class TwoTimestampStream {

    public class Pair{
        int value, timestamp;
        public Pair(int value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    LinkedBlockingDeque<Pair> inputStream1 = new LinkedBlockingDeque<>();
    LinkedBlockingDeque<Pair> inputStream2 = new LinkedBlockingDeque<>();

    LinkedBlockingDeque<Pair> processQ1 = new LinkedBlockingDeque<>();
    LinkedBlockingDeque<Pair> processQ2 = new LinkedBlockingDeque<>();

    public class Q1Processor extends Thread{
        public void run(){
            while(true) {
                Pair p1 = inputStream1.getFirst();
                getResult(processQ2, processQ1, p1);
            }
        }
    }

    public class Q2Processor extends Thread{
        public void run(){
            while(true) {
                Pair p2 = inputStream2.getFirst();
                getResult(processQ1, processQ2, p2);
            }
        }
    }

    public class ResultPair{
        Pair p1; Pair p2;
        public ResultPair(Pair p1, Pair p2){
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public List<ResultPair> result = new ArrayList<ResultPair>();

    //If not synchronized, two thread will generate duplicate result.
    public synchronized void getResult(Queue<Pair> q1, Queue<Pair> q2, Pair p){
        //If the new come pair is greater than q1.peek()+1, Since they are time stamp
        //Which means the future pair will greater than this too. So just pop out this value.
        while(p.timestamp - q1.peek().timestamp > 1){
            q1.poll();
        }
        q2.offer(p);
        for(Pair pair : q1){
            result.add(new ResultPair(pair, p));
        }
    }

    public void singleThreadProcess(){
        while(true){
            //If inputStream1 no coming data will block
            Pair p1 = inputStream1.getFirst();
            getResult(processQ2, processQ1, p1);
            //If inputStream2 no coming data will block
            Pair p2 = inputStream2.getFirst();
            getResult(processQ1, processQ2, p2);
        }
    }
}
