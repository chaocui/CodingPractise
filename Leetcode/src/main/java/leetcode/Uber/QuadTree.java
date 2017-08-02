package leetcode.Uber;

/**
 * Created by cc on 2017/6/21.
 */
public class QuadTree {
    // This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
        public class TreeNode{
            Integer val;
            TreeNode topLeft;
            TreeNode topRight;
            TreeNode bottomLeft;
            TreeNode bottomRight;
        }
        public TreeNode compress(int[][] matrix){
            return quadTree(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
        }
        public TreeNode quadTree(int[][] matrix, int rStart, int rEnd, int cStart, int cEnd){
            TreeNode result = new TreeNode();
            if(rStart == rEnd){
                result.val = matrix[rStart][cStart];
                return result;
            }
            //top left
            TreeNode topLeft = quadTree(matrix, rStart, (rEnd + rStart -1)/2, cStart, (cEnd + cStart -1)/2);
            //top right
            TreeNode topRight = quadTree(matrix, rStart, (rEnd + rStart -1)/2, (cEnd + cStart - 1)/2+1, cEnd);
            //bottom left
            TreeNode bottomLeft = quadTree(matrix, (rEnd + rStart -1)/2+1, rEnd, cStart, (cEnd + cStart -1)/2);
            //bottom right
            TreeNode bottomRight = quadTree(matrix, (rEnd + rStart -1)/2+1, rEnd, (cEnd + cStart - 1)/2+1, cEnd);
            if(merge(topLeft, topRight, bottomLeft, bottomRight) != null)
                result.val = topLeft.val;
            else{
                result.topLeft = topLeft;
                result.topRight = topRight;
                result.bottomLeft = bottomLeft;
                result.bottomRight = bottomRight;
            }
            return result;
        }
        public Integer merge(TreeNode n1, TreeNode n2, TreeNode n3, TreeNode n4){
            if(n1.val != null && n2.val != null && n3.val != null && n4.val != null &&
                    n1.val == n2.val && n2.val == n3.val && n3.val == n4.val)
                return n1.val;
            return null;
        }
        public static void main(String[] args){
            QuadTree c = new QuadTree();
            int[][] test = { {2, 2, 3, 3},
                    {2, 2, 3, 3},
                    {4, 2, 5, 5},
                    {2, 3, 5, 5}};
            TreeNode root = c.compress(test);
            System.out.println(root.bottomLeft.topLeft.val);
        }
// +---------+--------+----+----+--------+
// |  2 |  2 |  2 | 2 |  2 |  2 |  3 | 3 |
// +----|----|----|---|----|----|----|---|
// |  2 |  2 |  2 | 2 |  2 |  2 |  3 | 3 |
// +----+----|--------|----+----|----+---|
// |  2 |  2 | 2  | 2 |  4 |  2 |  5 | 5 |
// +----|----|----|---|----|----|----|---|
// |  2 |  2 |  2 | 2 |  2 |  3 |  5 | 5 |
// +----+----+--------+----+----+--------+
// |  2 |  2 |  3 | 3 |  2 |  2 |  3 | 3 |
// +----|----|----|---|----|----|----|---|
// |  2 |  2 |  3 | 3 |  2 |  2 |  3 | 3 |
// +----+----|--------|----+----|--------|
// |  4 |  2 |  5 | 5 |  4 |  2 |  5 | 5 |
// +----|----|----|---|----|----|----|---|
// |  2 |  3 |  5 | 5 |  2 |  3 |  5 | 5 |
// +----+----+--------+----+----+--------+








}
