package dp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> getSubsets(int [] nums){
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void generateSubsets(int numsIndex, int[] nums, ArrayList<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));
        for(int i=numsIndex; i<nums.length;++i){
            current.add(nums[i]);
            generateSubsets(i+1, nums, current, ans);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.getSubsets(new int [] {1,2,3}));
    }
}
