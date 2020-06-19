package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * A[i][j] = A[i-1][j] + A[i] [j-k] // k=play score
 * A[1,6] = A[0][6] + A[1][3] // For 2,3 play A[0][6] = 1 and A[1][3] = 1
 */

public class FootballScoreCombinations {
    public int numOfCombinationForFinalScore(int finalScore, List<Integer> plays) {
        int[][] numOfCombinations = new int[plays.size()][finalScore + 1];
        for (int i = 0; i < plays.size(); i++) {
            numOfCombinations[i][0] = 1; // 1 way to score 0 points
            for (int j = 1; j <= finalScore; j++) {
                int withoutThisPlay = i - 1 >= 0 ? numOfCombinations[i - 1][j] : 0;
                int withThisPlay = j >= plays.get(i) ? numOfCombinations[i][j - plays.get(i)] : 0;
                numOfCombinations[i][j] = withoutThisPlay + withThisPlay;
            }
        }
        return numOfCombinations[plays.size() - 1][finalScore];
    }

    public static void main(String[] args) {
        List<Integer> plays = new ArrayList<>();
        plays.add(2);
        plays.add(3);
        plays.add(7);
        FootballScoreCombinations combinations = new FootballScoreCombinations();
        System.out.println(combinations.numOfCombinationForFinalScore(12, plays));
    }
}
