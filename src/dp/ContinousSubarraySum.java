package dp;

public class ContinousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len<1) return false;

        int [] matrix = new int [len];
        for(int i=0; i<len ; ++i){
            matrix[i]=nums[i];
            for(int j=i+1; j<len; ++j){
                matrix[j] = matrix[j-1] + nums[j];
                if(k!=0 && matrix[j] % k == 0) return true;
                if(k==0 && matrix[j]==0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {0,1,0};
        ContinousSubarraySum subarraySum = new ContinousSubarraySum();
        System.out.println(subarraySum.checkSubarraySum(arr, 0));
    }
}
