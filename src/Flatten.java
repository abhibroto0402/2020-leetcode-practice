public class Flatten {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }

    }

    static class LinkedList {
        public Node header;
        public Node tail;
        LinkedList(Node head){
            this.header=new Node(head.val);
            this.tail=header;
        }
        void addTail(Node node){
            Node tempnode = new Node(node.val);
            tail.next=tempnode;
            tempnode.prev=tail;
            tail=tail.next;
        }
    }

    public Node flat(Node head) {
        LinkedList linkedList = new LinkedList(head);
        if (head.child != null)
            flattenHelper(linkedList, head.child);
        flattenHelper(linkedList, head.next);
        return linkedList.header;
    }

    private void flattenHelper(LinkedList linkedList, Node root) {
        if (root == null)
            return;
        linkedList.addTail(root);
        if (root.child != null) {
            flattenHelper(linkedList, root.child);
        }
        flattenHelper(linkedList, root.next);
    }

    public static void main(String[] args) {
        
        Flatten flatten = new Flatten();
        Node node = new Node(1);
        node.child = new Node(3);
        node.next = new Node(2);
//        Node node = new Node(12);
//        Node node2 = new Node(2);
//        node.next = node2;
//        node2.prev=node;
//        Node node3 = new Node(3);
//        node2.child = node3;
//        Node node4  = new Node(4);
//        node3.next = node4;
//        node4.prev = node3;
//        Node node5 = new Node(5);
//        node2.next=node5;
        Node n = flatten.flat(node);
        while (n != null) {
            System.out.print(n.val + "->");
            n = n.next;
        }
        System.out.print("null\n");
    }
}
