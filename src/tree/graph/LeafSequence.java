package tree.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Return if leaf nodes from one tree makes a subsequence of the other tree
 */

public class LeafSequence {
    Set<Integer> setNodes = new HashSet<>();
    Queue<Integer> leafNodes = new LinkedList<>();
    boolean flag = true;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        queueLeafNodes(root1);
        checkSequence(root2);
        return flag && leafNodes.isEmpty() ;
    }

    private void queueLeafNodes(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null){
            leafNodes.add(root.val);
            setNodes.add(root.val);

        }
        queueLeafNodes(root.left);
        queueLeafNodes(root.right);
    }

    private void checkSequence(TreeNode node){
        if(!flag || leafNodes.isEmpty() || node==null ) return;
        if(node.left==null && node.right==null){
            if(setNodes.contains(node.val)){
                if(leafNodes.peek()!=node.val){
                    flag=false;
                }

                else{
                    leafNodes.poll();
                    return;
                }
            }
        }
        checkSequence(node.left);
        checkSequence(node.right);
    }
}
