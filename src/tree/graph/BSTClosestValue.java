package tree.graph;

public class BSTClosestValue {
    double absMinDiff = Double.MAX_VALUE;
    int closest;
    public int closestValue(TreeNode root, double target) {
        double diff = root.val - target;
        if(diff==0) return root.val;
        if(Math.abs(diff)<absMinDiff){
            absMinDiff=Math.abs(diff);
            closest= root.val;
        }
        if(diff>0 && root.left!=null)
            return closestValue(root.left, target);
        if(diff<0 && root.right!=null)
            return closestValue(root.right, target);
        return closest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        BSTClosestValue closestValue = new BSTClosestValue();
        System.out.println(closestValue.closestValue(root, 3.428571));
    }
}
