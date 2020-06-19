package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int [amount+1];
        dp[0] = 0;
        for ( int i = 1; i<=amount ;i++){
            dp[i] = amount+1;
        }
        for ( int i = 0; i<=amount ;i++){
            for (int coin : coins){
                if(i>=coin){
                    dp[i] = Math.min(1+dp[i -coin],dp[i]);
                }

            }
        }
        return dp[amount] == amount+1?-1:dp[amount];

    }

    public static void main(String[] args) {
        int [] coins = {186,419,83,408};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, 6249));
        Set<Integer> validDigits = new HashSet(Arrays.asList(new int[]{0, 1, 8, 2, 5, 6, 9}));
    }
}
