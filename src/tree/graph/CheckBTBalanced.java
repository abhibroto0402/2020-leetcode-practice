package tree.graph;

public class CheckBTBalanced {
    class BalancedBinaryTree{
        int height;
        boolean isBalanced;
        public BalancedBinaryTree(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public boolean checkBalanced(TreeNode root){
        BalancedBinaryTree result=  check(root);
        System.out.println("Tree Height traversed" + result.height);
        return result.isBalanced;
    }

    private BalancedBinaryTree check(TreeNode root) {
        if(root==null)
            return new BalancedBinaryTree(-1, true);
        
        BalancedBinaryTree leftTree = check(root.left);
        if(!leftTree.isBalanced)
            return leftTree;
        BalancedBinaryTree rightTree = check(root.right);
        if(!rightTree.isBalanced)
            return rightTree;
        
        boolean isBalanced = Math.abs(leftTree.height - rightTree.height)<=1;
        int height = Math.max(leftTree.height, rightTree.height)+1;
        return new BalancedBinaryTree(height, isBalanced);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.left.left.right = new TreeNode(10);
        CheckBTBalanced btBalanced = new CheckBTBalanced();
        System.out.println(btBalanced.checkBalanced(root));

    }
}
