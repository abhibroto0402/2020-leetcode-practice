package tree.graph;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root){
        if(root==null)
            return 0;
        else if(root.left!=null && root.left.left==null && root.left.right==null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }else{
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    public static void main(String[] args) {
        SumOfLeftLeaves leftLeaves = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(2);
        root.left= new TreeNode(10);
        root.left.right= new TreeNode(4);
        root.left.left= new TreeNode(6);
        root.right= new TreeNode(2);
        root.right.left= new TreeNode(2);
        System.out.println(leftLeaves.sumOfLeftLeaves(root));
    }
}
