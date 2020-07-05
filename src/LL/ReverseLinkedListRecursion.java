package LL;

public class ReverseLinkedListRecursion {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode tempNode = reverseList(head.next);
        head.next.next = head;
        head.next=null;
        return tempNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkedListRecursion reverseLinkedListRecursion = new ReverseLinkedListRecursion();
        System.out.println(reverseLinkedListRecursion.reverseList(head));
    }
}
