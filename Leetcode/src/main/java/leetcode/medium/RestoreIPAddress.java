package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2016/8/7.
 */
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {

        if(s.length() > 12 || s.length() < 4){
            return new ArrayList<String>();
        }

        else{
            return getIpString(1, s);
        }

    }

    private List<String> getIpString(int part, String s){

        List<String> result = new ArrayList<>();
        if(part == 4){
            if(isValidIpSection(s)){
                result.add(s);
            }
            return result;
        }

        else{
            if(s.length() >= 1 && isValidIpSection(s.substring(0,1))){
                List<String> temp = getIpString(part+1, s.substring(1));
                if(temp.size() != 0){
                    for(String t:temp){
                        result.add(s.substring(0,1)+"."+t);
                    }
                }
            }
            if(s.length() >= 2 && isValidIpSection(s.substring(0,2))){
                List<String> temp = getIpString(part+1, s.substring(2));
                if(temp.size() != 0){
                    for(String t:temp){
                        result.add(s.substring(0,2)+"."+t);
                    }
                }
            }
            if(s.length() >= 3 && isValidIpSection(s.substring(0,3))){
                List<String> temp = getIpString(part+1, s.substring(3));
                if(temp.size() != 0){
                    for(String t:temp){
                        result.add(s.substring(0,3)+"."+t);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValidIpSection(String s){
        return (s.length() == 1)
                || (s.length() == 2 && s.charAt(0) != '0')
                || (s.length() == 3 && s.charAt(0) != '0' && Integer.parseInt(s) <= 255);

    }

    public static void main(String[] args){
        RestoreIPAddress ria = new RestoreIPAddress();
        List<String> result = ria.restoreIpAddresses("1111");
        for(String s : result){
            System.out.println(s);
        }
    }

}
