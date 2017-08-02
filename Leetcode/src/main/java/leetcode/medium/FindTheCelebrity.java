package leetcode.medium;

/**
 * Created by cc on 2017/5/22.
 */
public class FindTheCelebrity {

    //starting from 0.
    //since celebrity needs everyone knows him.
    //if doesnot know him, him is not a candidate.
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            //basically, if candidate knows i, than candidate become i.(celebrity does not know anyone.)
            //id candidate not know i, i is not candidate.(every one needs to know the celebrity)
            if(knows(candidate,i))
                candidate = i;
        }

        //validate, see candidate know anyone or everyone knows him
        //loop through all the people,
        //i is not candidate himself,
        // see if candidate knows him, if yes, then he is not.
        //or if i knows candidate, if not, then he is not.
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i,candidate))) return -1;
        }
        return candidate;
    }

    public boolean knows(int a, int b){
        return true;
    }
}
