package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2016/11/1.
 */
public class WordSearchII {
    public class TrieNode{
        TrieNode children[] = new TrieNode[26];
        String word = null;
    }

    List<String> result = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i,j,root,board);
            }
        }
        return result;
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        //Loop through words
        for(String word : words){
            //starting from root
            TrieNode node = root;
            char[] chars = word.toCharArray();
            //Each character in word
            for(char c : chars){
                int index = c - 'a';
                //check if the node already exists
                //if not create a new one
                if(node.children[index] == null){
                    node.children[index] = new TrieNode();
                }
                //Move node to current char
                node = node.children[index];
            }
            //after processing the last char. assign the word to this current node.
            node.word = word;
        }
        return root;
    }

    public void dfs(int i, int j, TrieNode root, char[][] board){
        char c = board[i][j];
        int index = c - 'a';
        //Check if this character is visited, or prefix is not in trie, break.
        if(c == '#' || root.children[index] == null){
            return;
        }
        TrieNode nextNode = root.children[index];
        if(nextNode.word != null){
            result.add(nextNode.word);
            //if found, not needed any more, we dont need duplicate strings in results
            nextNode.word = null;
        }
        //mark visited
        board[i][j] = '#';
        //Move up
        if(i - 1 >= 0){
            dfs(i-1, j, nextNode, board);
        }
        //Move down
        if(i + 1 < board.length){
            dfs(i+1, j, nextNode, board);
        }
        //Move left
        if(j - 1 >= 0){
            dfs(i, j - 1, nextNode, board);
        }
        //Move right
        if(j + 1 < board[0].length){
            dfs(i, j + 1, nextNode, board);
        }
        //change back after iterate all four direction.
        board[i][j] = c;
    }
}
