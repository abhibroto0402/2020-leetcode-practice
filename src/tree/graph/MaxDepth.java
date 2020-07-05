package tree.graph;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int max=0;
        max= helper(root);
        return max;
    }
    int helper(TreeNode node){
        if(node==null)
            return 0;
        int leftTree = helper(node.left);
        int rightTree = helper(node.right);
        return Math.max(leftTree, rightTree)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(1);
        root.right= new TreeNode(9);
        root.right.right= new TreeNode(4);
        root.right.left= new TreeNode(5);
        MaxDepth depth = new MaxDepth();
        System.out.println(depth.maxDepth(root));
    }
}
