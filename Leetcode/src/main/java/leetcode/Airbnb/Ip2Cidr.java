package leetcode.Airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/30.
 */
public class Ip2Cidr {


    public List<String> solution(String startIp, String endIp){

        List<String> result = new ArrayList<>();

        long start = ipToLong(startIp);
        long end = ipToLong(endIp);
        //equal need to keep going, startIp/32. which is one address cidr block
        while(start <= end){
            //bits of zerow of start

            //bits difference between end and start.
            double bits = Math.log(end-start+1)/Math.log(2);

            //take bigger one,
            //result.add(startIp/mask);
            //start = start + 2^(32-bits);
        }
        return result;
    }


    public long ipToLong(String startIp){
        String[] sl = startIp.split("\\.");
        long result = 0;
        for(int i = 0; i < sl.length; i++){
            result = result | Long.parseLong(sl[i]) << 8*(3-i);
        }
        return result;
    }

    public String longToIp(long ip){
        StringBuilder sb = new StringBuilder();
        sb.append(ip&0xFF000000 >>> 24).append(".").append(ip&0x00FF0000 >>> 16)
                .append(".").append(ip&0x0000FF00 >>> 8).append(".").append(ip&0x000000FF);
        return sb.toString();
    }

    public static void main(String[] args){

        Ip2Cidr ipc = new Ip2Cidr();
        System.out.println(ipc.ipToLong("123.123.123.123"));
        System.out.println(ipc.longToIp(ipc.ipToLong("123.123.123.123")));

    }


}
