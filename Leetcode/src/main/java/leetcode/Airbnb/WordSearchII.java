package leetcode.Airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/6/30.
 */
public class WordSearchII {

    //Instead of loop for words, and search them in matrix, this O(MNJ)
    /**
     * Basic idea is build Trie for words,
     * loop through matrix, for each element, check if starting as this element, we can find word in Trie by going
     * up, down, left, right.
     * */

    public class Node{
        Node[] children = new Node[26];
        String word;
    }

    public Node buildTrie(String[] words){
        Node root = new Node();
        for(int i = 0; i < words.length; i++){
            //each word, starting at root
            Node node = root;
            char[] ca = words[i].toCharArray();
            for(char c : ca){
                int index = c - 'a';
                if(node.children[index] == null){
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.word = words[i];
        }
        return root;
    }

    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root);
            }
        }
        return result;
    }

    public void dfs(char[][] board, int i, int j, Node root){
        char c = board[i][j];
        int index = c - 'a';
        if(c == '#' || root.children[index] == null)
            return;
        board[i][j] = '#';

        if(root.children[index].word != null){
            result.add(root.children[index].word);
            //we don't want dups
            root.children[index].word = null;
        }

        //up
        if(i - 1 >= 0)
            dfs(board, i-1, j, root.children[index]);

        //down
        if(i + 1 < board.length)
            dfs(board, i+1, j, root.children[index]);

        //left
        if(j - 1 >= 0)
            dfs(board, i, j-1, root.children[index]);

        //right
        if(j + 1 < board[0].length)
            dfs(board, i, j+1, root.children[index]);

        //back trace
        board[i][j] = c;
    }
}
