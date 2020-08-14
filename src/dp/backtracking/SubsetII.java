package dp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void generateSubsets(int numsIndex, int[] nums, ArrayList<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));
        for (int i = numsIndex; i < nums.length; ++i) {
            if (i == numsIndex || nums[i] != nums[i - 1]) {
                current.add(nums[i]);
                generateSubsets(i + 1, nums, current, ans);
                current.remove(current.size() - 1);
            }

        }
    }
}
