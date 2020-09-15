package tree.graph;

import java.util.ArrayList;
import java.util.List;

public class SumBTRootToLeaf {
    public List<Integer> getSumRootToLeaf(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        helper(root, ans, 0);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans, int curr) {
        if(root.left==null && root.right==null){
            ans.add(curr+ root.val);
            return;
        }
        if(root.left!=null)
            helper(root.left, ans, curr+root.val);
        if(root.right!=null)
            helper(root.right, ans, curr+root.val);
    }

    public static void main(String[] args) {
        SumBTRootToLeaf sumBTRootToLeaf = new SumBTRootToLeaf();
        TreeNode root = new TreeNode(24);
        root.left= new TreeNode(10);
        root.left.right= new TreeNode(4);
        root.left.left= new TreeNode(6);
        root.right= new TreeNode(2);
        root.right.right= new TreeNode(2);
        System.out.println(sumBTRootToLeaf.getSumRootToLeaf(root));
    }
}
