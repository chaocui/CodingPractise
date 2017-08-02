package TwoSigma;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by cc on 2016/8/14.
 */
public class ReversePolishNotation {

    private Map<String, Operator> operator = new HashMap();

    public int evaluate(String s){

        Stack<Integer> operands = new Stack();
        for(char c: s.toCharArray()){
            if(c == '+'){
                operands.push(operands.pop()+operands.pop());
            }
            else if(c == '-'){
                operands.push(-(operands.pop()-operands.pop()));
            }
            else if(c == '/'){
                operands.push(1/(operands.pop()/operands.pop()));
            }
            else if(c == '*'){
                operands.push(operands.pop()*operands.pop());
            }
            else{
                operands.push(Integer.parseInt(c+""));
            }
        }

        return operands.pop();
    }

    public ReversePolishNotation(){
        operator.put("+", new Add());
        operator.put("-", new Minus());
        operator.put("/", new Divid());
        operator.put("*", new Multiply());
    }

    public void registerOperator(String exp, Operator imp){
        operator.put(exp, imp);
    }

    public int eval(String s){

        Stack<Integer> operands = new Stack();
        for(char c: s.toCharArray()){
            if(operator.containsKey(c+"")){
                operands.push(operator.get(c+"").calculate(operands));
            }
            else{
                operands.push(Integer.parseInt(c+""));
            }
        }
        return operands.pop();
    }

    public interface Operator{
        public int calculate(Stack<Integer> operands);
    }

    public class Add implements Operator{
        public int calculate(Stack<Integer> operands){
            return Math.addExact(operands.pop(), operands.pop());
        }
    }

    public class Minus implements Operator{
        public int calculate(Stack<Integer> operands){
            int first = operands.pop();
            int second = operands.pop();
            return Math.subtractExact(second, first);
        }
    }

    public class Multiply implements Operator{
        public int calculate(Stack<Integer> operands){
            return Math.multiplyExact(operands.pop(), operands.pop());
        }
    }

    public class Divid implements Operator{
        public int calculate(Stack<Integer> operands){
            int first = operands.pop();
            int second = operands.pop();
            return Math.floorDiv(second, first);
        }
    }
}
