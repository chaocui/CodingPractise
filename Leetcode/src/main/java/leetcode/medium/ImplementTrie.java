package leetcode.medium;

/**
 * Created by cc on 2017/5/24.
 */
public class ImplementTrie {
    /** Initialize your data structure here. */
    public class Node{
        int wordCount = 0;
        Node[] children = new Node[26];
    }
    Node root;
    public ImplementTrie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(n.children[c-'a'] == null)
                n.children[c-'a'] = new Node();
            if(i == word.length() - 1)
                n.children[c-'a'].wordCount ++;
            n = n.children[c-'a'];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(n.children[c-'a'] == null)
                return false;
            if(i == word.length() - 1 && n.children[c-'a'].wordCount > 0)
                return true;
            n = n.children[c-'a'];
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(n.children[c-'a'] == null)
                return false;
            n = n.children[c-'a'];
        }
        return true;
    }
}
