package LL;

public class DeepCopy {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node iter = head;
        while(iter != null){
            Node newNode = new Node(iter.val);
            newNode.next = iter.next;
            iter.next = newNode;
            iter = newNode.next;
        }

        Node head2=head.next;
        iter=head;
        while(iter!=null){
            iter.next.random = iter.random==null? null:iter.random.next;
            iter=iter.next.next;
        }

        iter = head;
        Node iter2 = head2;
        while(iter!=null){
            iter.next=iter.next.next;
            iter=iter.next;
            iter2.next= iter2.next!=null? iter2.next.next:null;
            iter2=iter2.next;
        }
        return head2;
    }
}


