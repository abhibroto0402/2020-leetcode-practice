package tree.graph;

public class HeightOfBT {
    public int getHeightOfBT (TreeNode root){
        if(root==null) return 0;
        int leftMax= traverse(root.left, 1);
        int rightMax = traverse(root.right, 1);
        System.out.println("Left Subtree height: "+ leftMax);
        System.out.println("Right Subtree height: "+ rightMax);
        return Math.max(leftMax, rightMax);
    }

    private int traverse(TreeNode root, int height) {
        if(root==null) return 0;
        return Math.max(traverse(root.left, ++height), traverse(root.right, height))+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(9);
        root.right.right= new TreeNode(4);
        root.right.left= new TreeNode(5);
        HeightOfBT bt = new HeightOfBT();
        System.out.println(bt.getHeightOfBT(root));
    }
}
