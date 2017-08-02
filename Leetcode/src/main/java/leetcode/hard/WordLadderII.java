package leetcode.hard;

import java.util.*;

/**
 * Created by cc on 2016/10/29.
 */
public class WordLadderII {
    //BFS
    //queue

    /**
     * 吐血理解！简直一口老血吐在屏幕上...
     * BFS for sure.
     * Use map to track <End word, result list>
     * Queue only hold string,
     * for each word in queue,
     * 1. create temp map, hold endword, path list.
     * 2. use this word to generate new word, check if it is in outer map
     *      if in outer map, skip,
     *      if not in dictionary, skip.
     * 3. get the previous word path.
     * 4. loop though previous path, add this new word to path.
     * 5. add these new path to temp map.
     * 6. add temp map to outer map.
     * */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Map<String, List<List<String>>> result = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        List<List<String>> init = new ArrayList<>();
        List<String> initL = new ArrayList<>();
        initL.add(beginWord);
        init.add(initL);
        result.put(beginWord, init);
        boolean find = false;
        while(!queue.isEmpty()){
            //make sure to only traverse the current level
            int levelSize = queue.size();
            Map<String, List<List<String>>> levelCache = new HashMap<>();
            for(int i = 0; i < levelSize; i++){
                String pre = queue.poll();
                for(int m = 0; m < pre.length(); m++){
                    StringBuilder sb = new StringBuilder(pre);
                    for(int j = 0; j < 25; j++) {
                        sb.setCharAt(m, (char) ('a' + j));
                        String gS = sb.toString();
                        //if gS is already calculated ,or not in dict.
                        //since we are about to find the shortest, so if it is already calculated in previous level.
                        //this will be longer.
                        if (result.containsKey(gS) || !dict.contains(gS)) {
                            continue;
                        }
                        List<List<String>> preResult = result.get(pre);

                        List<List<String>> tempResult = levelCache.get(gS);
                        //if gS is not in levelCache, we need to add to queue,
                        //means we can transform to this gS, and we need to set gS as another part of path and keep tracing.
                        if (tempResult == null) {
                            queue.offer(gS);
                            tempResult = new ArrayList<List<String>>();
                            levelCache.put(gS, tempResult);
                        }

                        for (List<String> each : preResult) {
                            List<String> eachCopy = new ArrayList<>(each);
                            eachCopy.add(gS);
                            tempResult.add(eachCopy);
                        }

                        if (gS.equals(endWord))
                            find = true;
                    }
                }
            }
            if(find) return levelCache.get(endWord);
            result.putAll(levelCache);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        WordLadderII wd2 = new WordLadderII();
        List<String> test = Arrays.asList(new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"});
        System.out.println(wd2.findLadders("cet","ism",test).size());
    }
}
