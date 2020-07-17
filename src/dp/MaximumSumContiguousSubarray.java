package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumSumContiguousSubarray {

    public int getMaxSum(int[] arr) {
        int len = arr.length;
        int[] v = new int[len];
        v[0] = arr[0];
        int max = Integer.MIN_VALUE;
        int[] seq = new int[len];
        seq[0] = 0;
        for (int i = 1; i < len; ++i) {
            v[i] = Math.max(arr[i], arr[i] + v[i - 1]);
            seq[i] = v[i] == arr[i] ? i : i - 1;
            max = Math.max(v[i], max);
        }
        int index=0;
        for (int i =0; i<len; ++i){
            if(max==v[i]) {
                index = i;
                break;
            }
        }
        List<Integer> items = new ArrayList<>();
        items.add(arr[index]);
        while(index!=seq[index]){
            index=seq[index];
            items.add(arr[index]);
        }
        Collections.reverse(items);
        System.out.println(items);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -2};
        MaximumSumContiguousSubarray contiguousSubarray = new MaximumSumContiguousSubarray();
        int max = contiguousSubarray.getMaxSum(arr);
        System.out.println(max);
    }
}
