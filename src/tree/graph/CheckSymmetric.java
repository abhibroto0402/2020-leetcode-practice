package tree.graph;

public class CheckSymmetric {

    public boolean checkBTSymmetric(TreeNode root){
        if(root==null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if(left!=null && right!=null && left.val== right.val)
            return check(left.right, right.left) && check(left.left, right.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        CheckSymmetric symmetric = new CheckSymmetric();
        System.out.println(symmetric.checkBTSymmetric(root));

    }
}
