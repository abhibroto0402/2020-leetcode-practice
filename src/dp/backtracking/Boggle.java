package dp.backtracking;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Boggle {
    static final String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GUQ", "EE"};
    static final int n = dictionary.length;
    static final int M = 3, N = 3;
    static List<Pair<Integer, Integer>> steps = new ArrayList<>();
    static HashSet<String> created = new HashSet<>();

    // A given function to check if a given string is present in
    // dictionary. The implementation is naive for simplicity. As
    // per the question dictionary is given to us.
    static boolean isWord(String str) {
        // Linearly search all words
        for (int i = 0; i < n; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }


    // Prints all words present in dictionary.
    static void findWords(char[][] boggle) {
        boolean[][] visited = new boolean[boggle.length][boggle[0].length];
        steps.add(new Pair<>(-1, 0));
        steps.add(new Pair<>(-1, -1));
        steps.add(new Pair<>(-1, 1));
        steps.add(new Pair<>(1, 0));
        steps.add(new Pair<>(1, -1));
        steps.add(new Pair<>(1, 1));
        steps.add(new Pair<>(0, -1));
        steps.add(new Pair<>(0, 1));
        for (int i = 0; i < boggle.length; ++i) {
            for (int j = 0; j < boggle[0].length; ++j) {
                helper(boggle, new StringBuilder(), i, j, visited);
            }
        }
    }

    private static void helper(char[][] boggle, StringBuilder sb, int rowIndex, int colIndex, boolean[][] visited) {
        if (rowIndex < 0 || rowIndex >= boggle.length)
            return;
        if (colIndex < 0 || colIndex >= boggle[0].length)
            return;
        if (visited[rowIndex][colIndex])
            return;
        if (!created.contains(sb.toString()) && isWord(new String(sb))) {
            created.add(new String(sb));
            System.out.println(sb.toString());
            sb = new StringBuilder();

        }
        for (Pair<Integer, Integer> pair : steps) {
            if (!visited[rowIndex][colIndex]) {
                sb.append(boggle[rowIndex][colIndex]);
                visited[rowIndex][colIndex] = true;
                helper(boggle, sb, rowIndex + pair.getKey(), colIndex + pair.getValue(), visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[rowIndex][colIndex] = false;
            }
        }
    }


    // Driver program to test above function
    public static void main(String[] args) {
        char[][] boggle = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};

        System.out.println("Following words of dictionary are present");
        findWords(boggle);
    }
}
