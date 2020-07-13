package tree.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
        for(int i=0; i<inorder.length; ++i){
            nodeToInorderIdx.put(inorder[i], i);
        }
        return btPreorderInorder(preorder, 0, preorder.length, 0, inorder.length, nodeToInorderIdx);
    }

    private TreeNode btPreorderInorder(int[] preorder, int preorderStart, int preorderEnd,
                                       int inorderStart, int inorderEnd, Map<Integer, Integer> nodeToInorderIdx) {
        if(preorderEnd<=preorderStart || inorderEnd <=inorderStart)
            return null;
        int rootIndex = nodeToInorderIdx.get(preorder[preorderStart]);
        int leftSubtreeSize = rootIndex - inorderStart;

        TreeNode root = new TreeNode(preorder[preorderStart]);
        root.left = btPreorderInorder(preorder, preorderStart+1,
                preorderStart+leftSubtreeSize+1, inorderStart, rootIndex, nodeToInorderIdx);
        root.right = btPreorderInorder(preorder, preorderStart+leftSubtreeSize+1,
                preorderEnd, rootIndex+1, inorderEnd, nodeToInorderIdx);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeInorderPreorder inorderPreorder = new BuildTreeInorderPreorder();
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        System.out.println(inorderPreorder.buildTree(preorder, inorder));
    }
}
