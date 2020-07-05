package dp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineUtil(n, k, 1, list, temp);
        return list;
    }

    public void combineUtil(int n, int k, int index, List<List<Integer>> list, List<Integer> temp)
    {
        if(temp.size() == k)
        {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i <= n; i++)
        {
            temp.add(i);
            combineUtil(n, k, i+1, list, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
