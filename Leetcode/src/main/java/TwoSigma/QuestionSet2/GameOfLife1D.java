package TwoSigma.QuestionSet2;

/**
 * Created by cc on 2016/8/27.
 *
 * Rule,
 * 1. If live count == 1, 0->1
 * 2. If live count == 1, 1->0
 * 3. otherwise, stay the same
 *
 * so 0->0 status 0
 * 1->1 status 1
 * 0->1 status 3
 * 1->0 status 2
 *
 */
public class GameOfLife1D {

    public void gameOfLife(int[] array){

        int length = array.length;
        for(int i = 0; i < length; i++){

            int liveCount = 0;
            if(array[(i+length-1)%length] == 1 || array[(i+length-1)%length] == 2){
                liveCount++;
            }
            if(array[(i+length+1)%length] == 1 || array[(i+length+1)%length] == 2){
                liveCount++;
            }

            if(liveCount == 1){
                if(array[i] == 0){
                    array[i] = 3;
                }
                else if(array[i] == 1){
                    array[i] = 2;
                }
            }
        }

        for(int i = 0; i < length; i++){
            array[i] =  array[i]%2;
        }
    }
}
