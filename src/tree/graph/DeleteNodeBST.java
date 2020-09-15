package tree.graph;

public class DeleteNodeBST {
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(key>root.val) root.right= deleteNode(root.right, key);
        else if(key<root.val) root.left = deleteNode(root.left, key);
        else{
            if(root.left==null && root.right==null) root=null;
            else if(root.right!=null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            else{
                root.val= predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
        deleteNodeBST.deleteNode(root, 2);
    }
}
