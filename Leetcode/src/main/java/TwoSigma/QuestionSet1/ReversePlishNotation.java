package TwoSigma.QuestionSet1;

import TwoSigma.ReversePolishNotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by cc on 2016/8/28.
 */
public class ReversePlishNotation {

    public interface Operator{
        public void calculate(Stack<Integer> s);
    }

    private Map<String, Operator> operator = new HashMap<>();

    public ReversePlishNotation(){
        operator.put("+", new Add());
    }

    public void registerOperator(String expression, Operator o){
        this.operator.put(expression, o);
    }

    public int calculate(String s){

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+'){
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.charAt(i) == '-'){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first-second);
            }

            else if(s.charAt(i) == '*'){
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.charAt(i) == '/'){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first/second);
            }
            else{
                stack.push(Integer.parseInt(s.charAt(i)+""));
            }
        }
        return stack.pop();
    }

    public class Add implements Operator{
        public void calculate(Stack<Integer> s){
            s.push(s.pop()+s.pop());
        }
    }
}
