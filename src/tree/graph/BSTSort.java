package tree.graph;

import java.util.ArrayList;
import java.util.List;

public class BSTSort {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorder(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        inorder(root2,list2);
        return mergeSortedList(list1,list2);
    }
    private List<Integer> mergeSortedList(List<Integer> list1,List<Integer> list2) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()) {
            if(list1.get(i)<list2.get(j)) {
                list.add(list1.get(i++));
            } else {
                list.add(list2.get(j++));
            }
        }
        while(i<list1.size()) {
            list.add(list1.get(i++));
        }
        while(j<list2.size()) {
            list.add(list2.get(j++));
        }
        return list;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if(root!=null) {
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-10);
        root1.right = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);
        root2.right= new TreeNode(7);
        root2.left=new TreeNode(1);
        root2.left.left= new TreeNode(0);
        root2.left.right = new TreeNode(2);
        BSTSort sort =new BSTSort();
        System.out.println(sort.getAllElements(root1, root2));

        System.out.println(2>>1);
    }
}
