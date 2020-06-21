import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Set<Integer>> seenpair = new HashSet<>();
        for (int num : nums) {
            int diff = -num;
            Set<Integer> temp = getTwoSumResult(nums, diff);
            if (!temp.isEmpty() && seenpair.add(temp)) {
                temp.add(num);
                result.addAll(Collections.singleton(new ArrayList<>(temp)));
            }
        }
        return result;
    }


    private Set<Integer> getTwoSumResult(int[] nums, int target) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> complements = new HashSet<>();
        for (int num : nums) {
            int diff = target - num;
            if (complements.contains(diff)) {
                result.add(diff);
                result.add(num);
                return result;
            }
            complements.add(num);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
