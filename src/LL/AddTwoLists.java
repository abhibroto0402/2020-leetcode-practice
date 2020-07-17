package LL;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoLists {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return l1==null ? l2: l1;

        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        ListNode sentinel = new ListNode();
        while (l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int sum = s1.pop() + s2.pop()+carry;
            carry = sum / 10;
            if(sentinel.next==null){
                sentinel.next= new ListNode(sum%10);
            }else{
                ListNode temp = new ListNode(sum%10);
                temp.next= sentinel.next;
                sentinel.next=temp;
            }
        }

        while (!s1.isEmpty()){
            int sum = s1.pop() + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum%10);
            temp.next= sentinel.next;
            sentinel.next=temp;
        }

        while (!s2.isEmpty()){
            int sum = s2.pop() + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum%10);
            temp.next= sentinel.next;
            sentinel.next=temp;
        }
        if(carry!=0){
            ListNode temp = new ListNode(carry);
            temp.next= sentinel.next;
            sentinel.next=temp;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(4);

        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);

        AddTwoLists twoLists = new AddTwoLists();
        System.out.println(twoLists.addTwoNumbers(head1, head));
    }
}
