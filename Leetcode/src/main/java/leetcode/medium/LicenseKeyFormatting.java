package leetcode.medium;

/**
 * Created by cc on 2017/3/26.
 */
public class LicenseKeyFormatting {

    public char toUpperCase(char c){
        if(c >= 'a' && c <= 'z'){
            return (char)(c+ ('A' - 'a'));
        }
        return c;
    }

    public String licenseKeyFormatting(String S, int K) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(c != '-') {
                count++;
                sb.append(c);
            }
        }
        StringBuilder result = new StringBuilder();
        int groupCount = 0;
        for(int i = sb.length() - 1; i>=0; i--){
            if(groupCount == K){
                result.insert(0,'-');
                groupCount = 0;
                i++;
                continue;
            }
            result.insert(0,toUpperCase(sb.charAt(i)));
            groupCount++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting lkf = new LicenseKeyFormatting();
        String test = "2-4A0r7-4k";
        System.out.println(lkf.licenseKeyFormatting(test, 3));
        System.out.println(lkf.toUpperCase('C'));
        System.out.println(lkf.toUpperCase('2'));
    }

}
