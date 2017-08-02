package leetcode.medium;

/**
 * Created by cc on 2017/4/6.
 */
public class ValidateIPAddress {

    public String validIPAddress(String IP) {
        int length = IP.length();
        if(length == 0) return "Neither";
        char last = IP.charAt(length-1);
        if(last == '.' || last == ':') return "Neither";
        String[] parts = IP.split("\\.");
        if(parts.length == 4){
            for(String s : parts){
                if(s.length() > 3 || s.length() == 0) return "Neither";
                if(s.charAt(0) == '0' && s.length() > 1) return "Neither";
                if(s.compareTo("255") > 0 || s.compareTo("0") < 0) return "Neither";
            }
            return "IPv4";
        }
        else{
            parts = IP.split(":");
            if(parts.length != 8) return "Neither";
            for(String s : parts){
                if(s.length() > 4 || s.length() == 0) return "Neither";
                for(char c : s.toCharArray()){
                    if(c >= '0' && c <= '9') continue;
                    if(c >= 'a' && c <= 'f') continue;
                    if(c >= 'A' && c <= 'F') continue;
                    return "Neither";
                }
            }
            return "IPv6";
        }
    }

    public static void main(String[] args) {
        String test = "192.0.0.1";
        ValidateIPAddress vip = new ValidateIPAddress();
        System.out.println(vip.validIPAddress(test));
    }

}
