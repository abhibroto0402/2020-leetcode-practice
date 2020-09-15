import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class AdvantageCount {
    public int[] advantageCount(int[] a, int[] b) {
        int [] res = a;
        PriorityQueue<Pair<Integer, Integer>> maxB = new PriorityQueue<>(
                a.length, (x,y)-> y.getKey()-x.getKey());
        PriorityQueue<Integer> minA = new PriorityQueue<>();
        PriorityQueue<Integer> maxA = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<b.length;++i)
            maxB.add(new Pair<>(b[i],i));

        for (int j : a) {
            maxA.add(j);
            minA.add(j);
        }

        while(!maxB.isEmpty()){
            Pair<Integer, Integer> next = maxB.poll();
            if(maxA.peek()> next.getKey()){
                res[next.getValue()]= maxA.poll();
                minA.remove(res[next.getValue()]);
            }else{
                res[next.getValue()]= minA.poll();
                maxA.remove(res[next.getValue()]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        AdvantageCount count = new AdvantageCount();
        System.out.println(Arrays.toString(count.advantageCount(new int[]{2, 4, 5, 1}, new int[]{3, 6, 1, 2})));
    }
}
