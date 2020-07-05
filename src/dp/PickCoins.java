package dp;

import java.util.ArrayList;
import java.util.List;

public class PickCoins {
    public static int pickupCoins(List<Integer> coins) {
        return helper(coins, 0, coins.size() - 1, new int[coins.size()][coins.size()]);
    }

    private static int helper(List<Integer> coins, int a, int b, int[][] coinRange) {
        if (a > b) return 0;

        if (coinRange[a][b] == 0) {
            int maxRevenueA = coins.get(a) + Math.min(helper(coins, a + 1, b - 1, coinRange),
                    helper(coins, a + 2, b, coinRange));
            int maxRevenueB = coins.get(b) + Math.min(helper(coins, a+1, b-1, coinRange),
                    helper(coins, a, b-2, coinRange));
            coinRange[a][b] = Math.max(maxRevenueA, maxRevenueB);
        }
        return coinRange[a][b];
    }

    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>();
        coins.add(10);
        coins.add(25);
        coins.add(5);
        coins.add(10);
        coins.add(50);
        coins.add(25);
        coins.add(25);
        coins.add(5);
        coins.add(10);
        System.out.println(pickupCoins(coins));

    }
}
