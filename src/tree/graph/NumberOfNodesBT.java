package tree.graph;

public class NumberOfNodesBT {
    public int getCountOfNodes(TreeNode root){
        return helper(root, 0);
    }

    private int helper(TreeNode root, int i) {
        if(root==null) return i;
        i+= helper(root.right, i) + helper(root.left, i);
        return ++i;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left= new TreeNode(2);
        root.left.left= new TreeNode(6);
        root.right= new TreeNode(9);
        root.right.right= new TreeNode(4);
        root.right.left= new TreeNode(5);
        NumberOfNodesBT bt = new NumberOfNodesBT();
        System.out.println(bt.getCountOfNodes(root));
    }
}
