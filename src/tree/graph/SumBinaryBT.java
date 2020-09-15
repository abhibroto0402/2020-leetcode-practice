package tree.graph;

public class SumBinaryBT {
    int total=0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, "");
        return total;
    }

    private void helper(TreeNode root, String curr) {
        if(root.left==null && root.right==null){
            String str = curr + root.val;
            total += Integer.parseInt(str, 2);
            return;
        }
        if(root.left!=null)
            helper(root.left, curr +root.val);
        if(root.right!=null)
            helper(root.right, curr+root.val);
    }

    public static void main(String[] args) {
        SumBinaryBT binaryBT = new SumBinaryBT();
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(0);
        root.left.right= new TreeNode(0);
        root.left.left= new TreeNode(1);
        root.right= new TreeNode(1);
        root.right.right= new TreeNode(1);
        root.right.left= new TreeNode(0);
        System.out.println(binaryBT.sumRootToLeaf(root));
    }
}
