package LL;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode res = new ListNode();
        ListNode resPoint = res;
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            resPoint.next = queue.poll();
            resPoint = resPoint.next;
            if (resPoint.next != null) {
                queue.offer(resPoint.next);
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode head = new ListNode(-1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        lists[0] = head;
        head = new ListNode(-3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        lists[1] = head;
        head = new ListNode(-2);
        head.next = new ListNode(-1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(6);
        lists[2] = head;
        MergeKSortedLists sortedLists = new MergeKSortedLists();
        ListNode node = sortedLists.mergeKLists(lists);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
