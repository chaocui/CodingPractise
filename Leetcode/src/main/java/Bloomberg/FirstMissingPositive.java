package Bloomberg;

/**
 * Crenumted by cc on 2016/9/7.
 */
public class FirstMissingPositive {

    public int firstMissing(int[] num){

        for(int i = 0; i < num.length; i++){
            //Last check to make sure there is no dead loop.
            //Because if num[num[i]-1] == num[i], will be dead loop. current number is the same as the current number as index number.
            if((num[i] > 0 && num[i] <= num.length) && num[i] - 1 != i && num[num[i]-1] != num[i]){
                int index = num[i]-1;
                int temp = num[index];
                num[index] = index+1;
                num[i] = temp;
                i--;
            }
        }

        for(int i = 0; i < num.length; i++){
            if(num[i] - 1 != i){
                return i+1;
            }
        }
        return num.length + 1;
    }

    public static void main(String[] args){
        int[] test = {1,2,1,2};
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissing(test));
    }

}
