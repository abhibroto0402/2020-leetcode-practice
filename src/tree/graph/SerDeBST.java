package tree.graph;

import java.util.ArrayList;
import java.util.List;

public class SerDeBST {
    int index =0;

    public List<Integer> serialize(TreeNode root){
        List<Integer> result = new ArrayList<>();
        return serializerHelper(result, root);
    }

    private List<Integer> serializerHelper(List<Integer> result, TreeNode root) {
        if(root==null) return null;
        result.add(root.val);
        serializerHelper(result, root.left);
        serializerHelper(result, root.right);
        return result;
    }

    public TreeNode deserialize(List<Integer> list){
        return deserializeHelper(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(List<Integer> list, int minValue, int maxValue) {
        if(index>=list.size()) return null;
        int root = list.get(index);
        if(root<minValue || root > maxValue){
            return  null;
        }
        index++;
        TreeNode node = new TreeNode(root);
        node.left = deserializeHelper(list, minValue, root);
        node.right = deserializeHelper(list, root, maxValue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        SerDeBST bst = new SerDeBST();
        List<Integer> list = bst.serialize(root);
        System.out.println(list);
        System.out.println(bst.deserialize(list));
    }
}

