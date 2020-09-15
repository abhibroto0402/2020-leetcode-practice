import java.util.HashMap;
import java.util.Map;

public class ShortestSubarrayK {

    public int shortestSubarray(int[] arr, int k) {
        int len = arr.length;
        if(len<1) return -1;
        int min =Integer.MAX_VALUE, sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0; i<len ;++i){
            sum+=arr[i];
            if(map.containsKey(sum-k)){
                min= Math.min(min, i-map.get(sum-k)+1);
            }
            map.put(sum, i+1);
        }
        return min;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,4,4,-1,5};
        ShortestSubarrayK subarrayK = new ShortestSubarrayK();
        System.out.println(subarrayK.shortestSubarray(arr, 3));
    }
}
