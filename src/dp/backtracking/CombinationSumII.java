package dp.backtracking;

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int candidateIndex, int target, List<Integer> temp, List<List<Integer>> res) {
        if(target==0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<0) return;
        for(int i=candidateIndex;i<candidates.length; ++i){
            if(i==candidateIndex || candidates[i]!=candidates[i-1]){
                temp.add(candidates[i]);
                backtrack(candidates, i+1, target-candidates[i], temp, res);
                temp.remove(temp.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        CombinationSumII sumII = new CombinationSumII();
        System.out.println(sumII.combinationSum2(candidates, 8));
    }
}
