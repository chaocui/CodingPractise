package leetcode.hard;

/**
 * Created by cc on 2016/11/3.
 */
public class SelfCrossing {

    //Only 3 cases when lines crosses
    //In order to cross, at least 4 lines.
    //So if i < 3 return false;
    //for loop starting from i = 3;

    //case 1:　line 4 cross line 1, line 5 cross line 2 etc
    //condition a[0]>=a[2] && a[1] <= a[3], a[1] >= a[3] && a[2] <= a[4]
    //So a[i-3] >= a[i-1] && a[i-2] <= a[i]

    //This case will only happen at least five lines, i at least 4
    //So i >= 4
    //case 2: line 5 cross line 1, line 6 cross line 2 etc
    //condition a[1] == a[3] && a[4] >= a[2] - a[0]
    //so a[i-3] == a[i-1] && a[i] >= a[i-2] - a[i-4]

    //This case will only happen at least six lines, i at least 5
    //So i >= 5
    //case 3: line 6 cross line 1, line 7 cross line 2 etc
    //condition a[4] >= a[2] - a[0] && a[4] <= a[2] && a[3] >= a[1] && a[5] >= a[3] - a[1]
    //So a[i-1] >= a[i-3] - a[i-5] && a[i-1] <= a[i - 3] && a[i-2] >= a[i-4] && a[i] >= a[i-2] - a[i-4]

    public boolean isSelfCrossing(int[] x) {

        if(x == null){
            return false;
        }
        if(x.length < 3){
            return false;
        }

        for(int i = 3; i < x.length; i++){
            //case 1
            if(x[i-3] >= x[i-1] && x[i-2] <= x[i]){
                return true;
            }

            if(i >= 4){
                if(x[i-3] == x[i-1] && x[i] >= x[i-2] - x[i-4]){
                    return true;
                }
            }

            if(i >= 5){
                if(x[i-1] >= x[i-3] - x[i-5] && x[i-1] <= x[i - 3] && x[i-2] >= x[i-4] && x[i] >= x[i-2] - x[i-4]){
                    return true;
                }
            }
        }
        return false;
    }

}
