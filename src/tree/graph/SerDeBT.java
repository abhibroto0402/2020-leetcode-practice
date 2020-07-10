package tree.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerDeBT {

    public String serialize(TreeNode root){
        if(root==null) return "X";
        String rootLeft = serialize(root.left);
        String rootRight = serialize(root.right);
        return root.val+ "," + rootLeft  + ","+ rootRight;
    }

    public TreeNode deserialize(String s){
        Queue<String> nodesLeft = new LinkedList<>(Arrays.asList(s.split(",")));
        return deserializeHelper(nodesLeft);
    }

    private TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String current = nodesLeft.poll();
        if(current.equals("X")) return null;
        TreeNode currentNode = new TreeNode(Integer.parseInt(current));
        currentNode.left = deserializeHelper(nodesLeft);
        currentNode.right = deserializeHelper(nodesLeft);
        return currentNode;
    }

    public static void main(String[] args) {
        SerDeBT bt = new SerDeBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        String s = bt.serialize(root);
        System.out.println(s);
        System.out.println(bt.deserialize(s));
    }
}
