import java.util.*;

public class MaxHeapPq {

    public static void main(String[] args) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        max_heap.add(1);
        max_heap.add(1);
        max_heap.add(5);
        while (!max_heap.isEmpty()){
            System.out.println(max_heap.poll());
        }
    }
}
