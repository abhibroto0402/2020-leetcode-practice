package tree.graph;

/**
 * A complete tree has all the nodes filled upto second last level
 * Similar to performing binary search recursively find out perfect subtrees
 * Number of nodes in perfect subtrees = 2^h -1
 */

public class NumberOfNodesCompleteTree {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode leftIter = root.left;
        int leftCount = 1;
        while(leftIter!=null){
            leftIter=leftIter.left;
            ++leftCount;
        }

        TreeNode rightIter = root.right;
        int rightCount =1;
        while(rightIter!=null){
            rightIter = rightIter.right;
            ++rightCount;
        }
        if(leftCount==rightCount){
            return ((int) Math.pow(2, leftCount) - 1) ;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        int [] a = {1,2,6,7,9};
        int k=3;
        int ans=0;
        int n = a.length;
        if(a[n-1]== n)
            ans= n+k;
        if(a[0]!=1 && k<a[0])
            ans= k;
        int left = 0;
        int right = n-1;
        while(left<right){
            int mid = left + (right-left)/2;
            int missingCount=0;
            if(a[mid]!= mid+1){
                missingCount = a[mid]-(mid+1);
            }
            if(missingCount>k){
                right=mid;
            }else
                left=mid+1;
        }
        ans= left-1<0? a[left]+k:a[left-1]+k;
        System.out.println(ans);
    }
}
