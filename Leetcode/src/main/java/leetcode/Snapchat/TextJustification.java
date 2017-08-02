package leetcode.Snapchat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cc on 2017/6/17.
 */
public class TextJustification {

    /**
     * Since we need to evenly distributed.
     * the remaining need to be assigned evenly to left gaps. 1 to each.
     * */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int end = 0, start = 0;
        while(end < words.length){
            int length = words[start].length();
            end = start+1;
            //excluding end.
            for(int i = end; i < words.length; i++){
                if(length + 1 + words[i].length() > maxWidth) break;
                length += 1 + words[i].length();
                end++;
            }
            //if last line or only one word, left adjust
            if(end == words.length || end - start == 1){
                StringBuilder sb = new StringBuilder();
                for(int i = start; i < end; i++)
                    sb.append(words[i]).append(" ");
                sb.deleteCharAt(sb.length()-1);
                for(int i = sb.length(); i < maxWidth; i++)
                    sb.append(" ");
                //Since we excluding end, set start = end and start the next loop
                result.add(sb.toString());
                start = end;
                continue;
            }
            int gap = (maxWidth - length)/(end - start - 1);
            int remain = (maxWidth - length)%(end - start - 1);
            StringBuilder sb = new StringBuilder();
            for(int i = start; i < end; i++){
                sb.append(words[i]);
                if(i < end - 1){
                    for(int j = 0; j <= gap + ((i - start) < remain ? 1 : 0); j++)
                        sb.append(" ");
                }
            }
            result.add(sb.toString());
            start = end;
        }
        return result;
    }

    public List<String> fullJustify1(String[] words, int L) {
        List<String> list = new LinkedList<String>();
        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= L; w++) {
                len += words[w].length() + 1;
            }
            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) { // not 1 char, not last line
                space = (L - len) / (w - i - 1) + 1;
                extra = (L - len) % (w - i - 1);
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) strBuilder.append(' ');
                if (extra-- > 0) strBuilder.append(' ');
                strBuilder.append(words[j]);
            }
            int strLen = L - strBuilder.length();
            while (strLen-- > 0) strBuilder.append(' ');
            list.add(strBuilder.toString());
        }
        return list;
    }


    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] test = {"Listen","to","many,","speak","to","a","few."};
        List<String> result = tj.fullJustify(test,6);
        for(String s: result)
            System.out.println(s);
    }
}
