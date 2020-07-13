package dp;

public class InfiniteCoinChange {
    public int change(int amount, int [] coins){
        int n=coins.length;
        if(n==0){
            if(amount==0)
                return 1;
            else
                return 0;
        }
        int [] dp = new int [amount+1];
        for(int coin : coins) {
            dp[0] = 1;
            for (int i = coin; i <= amount; ++i) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        InfiniteCoinChange coinChange = new InfiniteCoinChange();
        System.out.println(coinChange.change(5,new int [] {1,2,5}));
    }
}
