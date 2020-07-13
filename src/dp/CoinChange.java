package dp;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */

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
    }
}
