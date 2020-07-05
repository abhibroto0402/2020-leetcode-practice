package tree.graph;

/**
 * A complete tree has all the nodes filled upto second last level
 * Similar to performing binary search recursively find out perfect subtrees
 * Number of nodes in perfect subtrees = 2^h -1
 */

public class NumberOfNodesCompleteTree {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode leftIter = root.left;
        int leftCount = 1;
        while(leftIter!=null){
            leftIter=leftIter.left;
            ++leftCount;
        }

        TreeNode rightIter = root.right;
        int rightCount =1;
        while(rightIter!=null){
            rightIter = rightIter.right;
            ++rightCount;
        }
        if(leftCount==rightCount){
            return ((int) Math.pow(2, leftCount) - 1) ;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
