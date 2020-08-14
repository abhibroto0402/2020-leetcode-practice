package tree.graph;

import javafx.util.Pair;

import java.util.*;

public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Map<Integer, List<Pair<Integer, Integer>>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        dfs(map, root, q, 0, 0);

        for(Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : map.entrySet()){
            List<Pair<Integer, Integer>> list = entry.getValue();
            Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o1.getKey() - o2.getKey();
                }
            });
            List<Integer> tempList = new ArrayList<>();
            list.forEach(p-> tempList.add(p.getValue()));
            ans.add(tempList);
        }
        return ans;
    }

    private void dfs(Map<Integer, List<Pair<Integer, Integer>>> map, TreeNode root, Queue<TreeNode> q, int dist, int level) {
        List<Pair<Integer, Integer>> tempList = map.getOrDefault(dist, new ArrayList<>());
        tempList.add(new Pair<>(level, root.val));
        map.put(dist,tempList );
        q.add(root);
        while (!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null){
                dfs(map, temp.left, q, dist-1, level+1);
            }
            if(temp.right!=null){
                dfs(map, temp.right, q, dist+1, level+1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(5);
        root.left.right= new TreeNode(6);
        root.right.right= new TreeNode(7);
        VerticalTraversal verticalTraversal = new VerticalTraversal();
        System.out.println(verticalTraversal.verticalTraversal(root));
    }
}
