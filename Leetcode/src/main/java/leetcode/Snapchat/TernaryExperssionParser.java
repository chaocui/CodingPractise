package leetcode.Snapchat;

/**
 * Created by cc on 2017/6/16.
 */
public class TernaryExperssionParser {

    /**
     *  Since the rule is group expression from right to left.
     *  So we find the last index of ?, and the 5 length string is one expression.
     *  evaluate this express, replace the original string with value,
     *  and do the same thing on the new expression.
     *  until the expression length is 1.
     *  Then loop finish. we find the result.
     * */
    public String parseTernary(String expression) {
        StringBuilder sb = new StringBuilder(expression);
        while(sb.length()!=1){
            int firstIndex = sb.lastIndexOf("?");
            int start = firstIndex - 1;
            int end = firstIndex + 4;
            String v = evaluate(sb.substring(start, end));
            sb.replace(start, end, v);
        }
        return sb.toString();
    }

    private String evaluate(String s){
        char c = s.charAt(0);
        if(c == 'T') return s.charAt(2)+"";
        else return s.charAt(4)+"";
    }

    public static void main(String[] args) {
        TernaryExperssionParser tep = new TernaryExperssionParser();
        System.out.println(tep.parseTernary("T?T:F?T?1:2:F?3:4"));
    }
}
