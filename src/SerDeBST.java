import java.util.ArrayList;
import java.util.List;

public class SerDeBST {
    int index =0;

    public List<Integer> serialize(Node root){
        List<Integer> result = new ArrayList<>();
        return serializerHelper(result, root);
    }

    private List<Integer> serializerHelper(List<Integer> result, Node root) {
        if(root==null) return null;
        result.add(root.val);
        serializerHelper(result, root.left);
        serializerHelper(result, root.right);
        return result;
    }

    public Node deserialize(List<Integer> list){
        return deserializeHelper(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Node deserializeHelper(List<Integer> list, int minValue, int maxValue) {
        if(index>=list.size()) return null;
        int root = list.get(index);
        if(root<minValue || root > maxValue){
            return  null;
        }
        index++;
        Node node = new Node(root);
        node.left = deserializeHelper(list, minValue, root);
        node.right = deserializeHelper(list, root, maxValue);
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.left.left = new Node(1);
        root.right.right = new Node(7);
        SerDeBST bst = new SerDeBST();
        List<Integer> list = bst.serialize(root);
        System.out.println(list);
        System.out.println(bst.deserialize(list));
    }
}

