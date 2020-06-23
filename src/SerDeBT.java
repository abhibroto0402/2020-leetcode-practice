import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerDeBT {

    public String serialize(Node root){
        if(root==null) return "X";
        String rootLeft = serialize(root.left);
        String rootRight = serialize(root.right);
        return root.val+ "," + rootLeft  + ","+ rootRight;
    }

    public Node deserialize(String s){
        Queue<String> nodesLeft = new LinkedList<>(Arrays.asList(s.split(",")));
        return deserializeHelper(nodesLeft);
    }

    private Node deserializeHelper(Queue<String> nodesLeft) {
        String current = nodesLeft.poll();
        if(current.equals("X")) return null;
        Node currentNode = new Node(Integer.valueOf(current));
        currentNode.left = deserializeHelper(nodesLeft);
        currentNode.right = deserializeHelper(nodesLeft);
        return currentNode;
    }

    public static void main(String[] args) {
        SerDeBT bt = new SerDeBT();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        String s = bt.serialize(root);
        System.out.println(s);
        System.out.println(bt.deserialize(s));
    }
}
