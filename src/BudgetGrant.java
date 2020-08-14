import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BudgetGrant {

    private int findGrantsCap(int [] grantsArray, int budgetCap){
        Arrays.sort(grantsArray);
        int left =0;
        int length = grantsArray.length;
        int right = length -1;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum;
        for(int i = 0; i< length; i++){
            sum=+ grantsArray[i];
            sumMap.put(i, sum);
        }
        while(left<right){
            int mid= left + (right-left)/2;
            if(satisfy(sumMap,length-mid-1, grantsArray[mid], mid , budgetCap)){
                return helper(grantsArray[mid+1]-1, grantsArray[mid], length-mid-1, budgetCap, sumMap.get(mid));
            }
            else
                right=mid;
        }
        return grantsArray[left];
    }

    private int helper(int upperLimit, int lowerLimit, int len, int budgetCap, Integer curr) {
        for(int i=upperLimit; i>=lowerLimit;--i){
            int potential = i * len;
            if(budgetCap - (potential + curr)  == 0)
                return i;
        }
        return lowerLimit;
    }

    private boolean satisfy(Map<Integer, Integer> sumMap, int len, int candidate, int mid,int budgetCap) {
        return sumMap.get(mid) + len * candidate <= budgetCap ;
    }

    public static void main(String[] args) {
        BudgetGrant grant = new BudgetGrant();
   //     System.out.println(grant.findGrantsCap(new int [] {2, 100, 50, 120, 1000}, 190));
        System.out.println(grant.findGrantsCap(new int [] {2, 100, 50, 120, 1000}, 210));
    }
}
