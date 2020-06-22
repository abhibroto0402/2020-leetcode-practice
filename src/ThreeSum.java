import javafx.util.Pair;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Pair> found = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i]))
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        int v1 = Math.min(nums[i], Math.min(complement, nums[j]));
                        int v2 = Math.max(nums[i], Math.max(complement, nums[j]));
                        if (found.add(new Pair(v1, v2)))
                            res.add(Arrays.asList(nums[i], complement, nums[j]));
                    }
                    seen.put(nums[j], i);
                }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
