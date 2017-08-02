package leetcode.Airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/30.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int end = 0, start = 0;
        while(end < words.length){
            int len = words[start].length();
            end = start + 1;
            //end exclusive
            while(end < words.length && len + 1 + words[end].length() <= maxWidth){
                len = len + 1 + words[end].length();
                end++;
            }
            //if last line or just one word, left adjust
            if(end == words.length || end - start == 1){
                StringBuilder sb = new StringBuilder();
                for(int i = start; i < end; i++)
                    sb.append(words[i]).append(" ");
                sb.deleteCharAt(sb.length() - 1);
                for(int i = sb.length(); i < maxWidth; i++)
                    sb.append(" ");
                result.add(sb.toString());
                start = end;
                continue;
            }

            //otherwise, distribute.
            int span = (maxWidth - len)/(end-start-1);
            int remain = (maxWidth - len)%(end-start-1);
            StringBuilder sb = new StringBuilder();
            for(int i = start; i < end; i++){
                sb.append(words[i]);
                //last word don't need to append any spaces at the end.
                if(i < end - 1) {
                    for (int j = 0; j <= span + (remain > 0 ? 1 : 0); j++)
                        sb.append(" ");
                }
                remain--;
            }
            result.add(sb.toString());
            start = end;
        }
        return result;
    }

}
