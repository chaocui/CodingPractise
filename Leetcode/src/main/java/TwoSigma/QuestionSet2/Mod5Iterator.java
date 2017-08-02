package TwoSigma.QuestionSet2;

import java.util.Random;

/**
 * Created by cc on 2016/8/28.
 */
public class Mod5Iterator {

    public int next(){
        Random r = new Random();
        return r.nextInt();
    }

    public boolean hasNext(){
        return true;
    }

    public class Mod5Iteratora extends Mod5Iterator{

        boolean calledHasNext = false;
        int nextVal = 0;

        public int next(){
            if(calledHasNext || hasNext()){
                calledHasNext = false;
                return nextVal;
            }
            else
                throw new RuntimeException("no more");
        }

        public boolean hasNext(){
            if(calledHasNext){
                return nextVal%5==0;
            }
            else{
                calledHasNext = true;
                while(super.hasNext()){
                    nextVal = super.next();
                    if(nextVal%5==0){
                        break;
                    }
                }
                return nextVal%5==0;
            }
        }
    }

    public static void main(String[] args){

        Mod5Iteratora m = new Mod5Iterator().new Mod5Iteratora();
        Mod5Iterator n  = new Mod5Iterator();
        System.out.println(m.next());
        System.out.println(m.next());
        System.out.println(m.next());
        System.out.println(m.next());

        System.out.println(n.next());
        System.out.println(n.next());
        System.out.println(n.next());
        System.out.println(n.next());
    }
}
