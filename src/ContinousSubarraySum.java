import java.util.HashMap;
import java.util.Map;

public class ContinousSubarraySum {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len<1) return -1;

        int count =0, sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<len ;++i){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] arr = {2,2,3,4,-2,5};
        ContinousSubarraySum subarraySum = new ContinousSubarraySum();
        System.out.println(subarraySum.subarraySum(arr, 3));
    }
}
