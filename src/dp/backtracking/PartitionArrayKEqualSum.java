package dp.backtracking;

import java.util.Arrays;

public class PartitionArrayKEqualSum {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if(k==0 || total %k !=0)
            return false;

        int target = total/k;
        boolean [] used = new boolean[nums.length];
        return partition(0, nums, used, k,0 ,target);
    }

    private boolean partition(int iter, int[] nums, boolean[] used, int k, int current, int target) {
        if (k == 1)
            return true;
        if (current > target)
            return false;
        if (current == target) {
            return partition(0, nums, used, k - 1, 0, target);
        }
        for (int i = iter; i < nums.length; ++i) {
            if (!used[i] && current + nums[i] <= target) {
                used[i] = true;
                if (partition(i + 1, nums, used, k, current + nums[i], target))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionArrayKEqualSum arrayKEqualSum = new PartitionArrayKEqualSum();
        System.out.println(arrayKEqualSum.canPartitionKSubsets(new int [] {4, 3, 2, 3, 5, 2, 1}, 4));

    }
}
