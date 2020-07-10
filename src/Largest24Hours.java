import java.util.*;

public class Largest24Hours {
    public String largestTimeFromDigits(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i: arr)
            set.add(i);
        if(set.contains(2)) {
            sb.append(2);
            set.remove(2);
        }else if(set.contains(1)){
            sb.append(1);
            set.remove(1);
        }else if(set.contains(0)){
            sb.append(0);
            set.remove(0);
        }else return sb.toString();

        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        max_heap.addAll(set);
        sb.append(max_heap.poll());
        sb.append(":");
        sb.append(max_heap.poll());
        sb.append(max_heap.poll());
        return sb.toString();

    }

    public static void main(String[] args) {
        Largest24Hours hours = new Largest24Hours();
        int [] arr = {1,2,3,4};
        System.out.println(hours.largestTimeFromDigits(arr));

    }
}
