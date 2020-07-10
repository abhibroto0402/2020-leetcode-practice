import java.util.*;

public class MaxHeapPq {

    public static void main(String[] args) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        max_heap.add(2);
        max_heap.add(10);
        max_heap.add(5);
        while (!max_heap.isEmpty()){
            System.out.println(max_heap.poll());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();
    }
}
