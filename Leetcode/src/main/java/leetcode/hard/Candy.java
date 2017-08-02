package leetcode.hard;

/**
 * Created by cc on 2016/11/7.
 */
public class Candy {

    //Basic idea
    //Loop from left to right, if bigger than left, get one more candy, otherwise get 1.
    //Loop from right to left, if bigger than right, get one more than right. take the bigger one of candy[i+1] + 1, candy[i].
    //So no need to have one more loop, two loop can have the final result.
    public int candy(int[] ratings) {

        int result = 0;
        int tempC[] =  new int[ratings.length];
        tempC[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                tempC[i] = tempC[i-1] + 1;
            }
            else{
                tempC[i] = 1;
            }
        }

        result = tempC[ratings.length-1];
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                tempC[i] = Math.max(tempC[i+1] + 1, tempC[i]);
            }
            result += tempC[i];
        }
        return result;
    }
}
