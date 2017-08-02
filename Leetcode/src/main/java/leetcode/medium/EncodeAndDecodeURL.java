package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cc on 2017/4/5.
 */
public class EncodeAndDecodeURL {

    Map<String, String> store = new HashMap<String, String>();
    StringBuilder charList = new StringBuilder();
    {
        for(int i = 0; i < 26; i++){
            charList.append((char)('a'+i));
            charList.append((char)('A'+i));
            if(i < 10)
                charList.append(i);
        }
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        do {
            for (int i = 0; i < 6; i++) {
                sb.append(charList.charAt((int) (Math.random() * 62)));
            }
        }while(store.containsKey(sb.toString()));
        store.put(sb.toString(),longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return store.get(shortUrl.substring(shortUrl.length()-6));
    }
}
