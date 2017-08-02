package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2016/8/7.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        if(n == 0) {
            return new ArrayList<>();
        }

        List<String> existing = new ArrayList<>();
        existing.add("(");
        return generate(n-1,n,existing);

    }


    private List<String> generate(int left, int right, List<String> existing){

        if(left == 0){
            List<String> result = new ArrayList<>();
            for(String s : existing){
                String each = s;
                while(right > 0) {
                    each += ")";
                    right --;
                }
                result.add(each);
            }
            return result;
        }

        List<String> result = new ArrayList<>();
        if(left == right){

            List<String> temp = new ArrayList<>();
            for(int i = 0; i < existing.size(); i++){
                temp.add(existing.get(i)+"(");
            }

            result.addAll(generate(left-1,right, temp));
        }

        else if(left < right){

            List<String> tempLeft = new ArrayList<>();
            for(int i = 0; i < existing.size(); i++){
                tempLeft.add(existing.get(i)+"(");
            }
            List<String> appLeft = generate(left-1,right,tempLeft);

            List<String> tempRight = new ArrayList<>();
            for(int i = 0; i < existing.size(); i++){
                tempRight.add(existing.get(i)+")");
            }
            List<String> appRight = generate(left,right-1,tempRight);

            result.addAll(appLeft);
            result.addAll(appRight);
        }

        return result;
    }


    public static void main(String[] args){
        GenerateParentheses gp = new GenerateParentheses();
        List<String> result = gp.generateParenthesis(3);
        for(String s : result){
            System.out.println(s);
        }
    }

}
