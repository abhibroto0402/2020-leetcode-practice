package tree.graph;

public class SumTree {
    class State{
        int sum;
        boolean flag;

        public State(int sum, boolean flag) {
            this.sum = sum;
            this.flag = flag;
        }
    }

    public boolean checkSumTree(TreeNode root){
        if(root==null)
            return true;
        State state= helpCheck(root);
        return state.flag;
    }

    private State helpCheck(TreeNode root) {
        if(root==null)
            return new State(0, true);
        State left = helpCheck(root.left);
        State right = helpCheck(root.right);
        boolean flag = (left.sum + right.sum == root.val || left.sum + right.sum==0);
        return new State(left.sum+ right.sum+ root.val, left.flag && right.flag && flag);
    }

    public static void main(String[] args) {
        SumTree tree = new SumTree();
        TreeNode root = new TreeNode(24);
        root.left= new TreeNode(10);
        root.left.right= new TreeNode(4);
        root.left.left= new TreeNode(6);
        root.right= new TreeNode(2);
        root.right.right= new TreeNode(2);
        System.out.println(tree.checkSumTree(root));
    }
}
