package leetcode.medium;

/**
 * Created by cc on 2017/2/14.
 */
public class MultiplyStrings {

    //Mimic real multiplication.
    //From right to left.
    //One trick is :
    //Lets say index i and j,
    //Multiply result will fit in result i+j and i+j+1 index.
    public String multiply(String num1, String num2){
        int l1 = num1.length(), l2 = num2.length();
        if(l1 == 0 || l2 == 0) return "0";
        int[] result = new int[l1+l2];
        for(int i = l1 -1; i >= 0; i--){
            for(int j = l2 - 1; j >= 0; j--){
                int prod = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int p1 = i+j, p2 = i+j+1;
                int sum = prod + result[p2];
                /***
                 * Position p1 need to add current with the existing number.
                 * Even it exceeding 10, means result[i] > 10.
                 * When calculating the next number, it still roll up to the next position.
                 * So we need to add current to previous existing.
                 * result[p1] += sum/10;
                 *
                 * Position p1 need to add current with the existing number,
                 * Even  it exceeding 10, means result[10] > 10
                 * When calculating the next number, it still roll up to the next position.
                 * So we need to add current to previous existing
                 * Result[p1] += sum/10;
                 *
                  * */
                result[p1] = result[p1] + sum / 10;
                result[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            if(sb.length()==0 && result[i] == 0) continue;
            sb.append(result[i]);
        }
        return sb.length() == 0? "0":sb.toString();
    }

    public String multiply1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        String carry = "";
        String result = "0";
        for(int i = num1.length()-1; i >= 0; i--){
            int n = Integer.parseInt(num1.charAt(i)+"");
            String multiply = multiply(n,num2)+carry;
            result = add(result, multiply);
            carry += "0";
        }
        while(result.length() > 1){
            if(result.charAt(0) == '0')
                result = result.substring(1);
            else
                break;
        }
        return result;
    }

    private String multiply(int n, String num){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num.length() - 1; i >= 0; i--){
            int tempN = Integer.parseInt(num.charAt(i)+"");
            int prod = tempN*n + carry;
            int result = prod%10;
            carry = prod/10;
            sb.insert(0,result);
        }
        if(carry == 0)
            return sb.toString();
        else
            return sb.insert(0,carry).toString();
    }

    private String add(String num1, String num2){
        int l1 = num1.length(), l2 = num2.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i,j;
        for(i = l1-1, j = l2 - 1; i >= 0 && j >= 0; i--, j--){
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            int n2 = Integer.parseInt(num2.charAt(j)+"");
            int add = n1+n2+carry;
            carry = add/10;
            int result = add%10;
            sb.insert(0,result);
        }

        if(j < 0 && i < 0){
            if(carry == 0)
                return sb.toString();
            else
                return sb.insert(0,carry).toString();
        }

        if(j < 0){
            if(carry == 0)
                return sb.insert(0,num1.substring(0,i+1)).toString();
            else
                return sb.insert(0,add(carry+"",num1.substring(0,i+1))).toString();
        }

        if(i < 0){
            if(carry == 0)
                return sb.insert(0,num2.substring(0,j+1)).toString();
            else
                return sb.insert(0,add(carry+"",num2.substring(0,j+1))).toString();
        }

        return sb.toString();
    }

    public static void main(String[] args){
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("9","9"));
    }

}
