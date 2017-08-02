package leetcode.medium;

import java.util.HashMap;

/**
 * Created by cc on 2016/7/17.
 */
public class WordDictionary {

    private Node root = new Node();
    private class Node{
        Node[] children = null;
        int wordCount = 0;
        public Node(){
            this.children = new Node[26];
        }
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        Node iteratorTree = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            Node charNode = iteratorTree.children[index];
            if(charNode == null){
                iteratorTree.children[index] = new Node();
                charNode = iteratorTree.children[index];
            }
            iteratorTree = charNode;
            if(i == word.length() - 1){
                charNode.wordCount ++;
            }
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, Node node, int start){
        /*
        * Node is one level above start index,
        * So when start reach the word lenth(last character + 1), means that node is the last character.
        * */

        if(start == word.length()){
            return node.wordCount > 0;
        }

        if(word.charAt(start) == '.'){
            for(Node n : node.children){
                if(n != null && search(word, n, start + 1)){
                    return true;
                }
            }
            return false;
        }
        else{
            int index = word.charAt(start)-'a';
            return node.children[index] != null && search(word, node.children[index], start+1);
        }
    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
    public static void main(String[] args){
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        System.out.println(wd.search("."));
    }


}
