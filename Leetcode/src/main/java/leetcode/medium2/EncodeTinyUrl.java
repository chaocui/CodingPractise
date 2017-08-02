package leetcode.medium2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2017/4/29.
 */
public class EncodeTinyUrl {

    // Encodes a URL to a shortened URL.
    Map<String, String> dict = new HashMap<>();
    List<Character> charList = new ArrayList<Character>();
    final int URL_LENGTH = 6;
    public EncodeTinyUrl(){
        for(int i = 0; i < 26; i++){
            charList.add((char)('a'+i));
            charList.add((char)('A'+i));
        }
        for(int i = 0; i < 10; i++)
            charList.add((char)('0'+i));
    }

    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        //If contains, then generate another one.
        do{
            for(int i = 0; i < URL_LENGTH; i++)
                sb.append(charList.get((int)(Math.random() * 62)));
        }while(dict.containsKey(sb.toString()));
        dict.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //just take last 6 characters.
        //ignore previous http:// or https://
        return dict.get(shortUrl.substring(shortUrl.length() - 6));
    }

}
