package dp.backtracking;

public class WordSearch {
    String word;
    char[][] board;
    int[] rowOffsets = {0, 1, 0, -1};
    int[] colOffsets = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int row = 0; row < ROWS; ++row)
            for (int col = 0; col < COLS; ++col)
                if (this.backtrack(row, col, 0))
                    return true;
        return false;
    }

    private boolean backtrack(int row, int column, int wordIndex) {
        if (wordIndex >= word.length())
            return true;
        if (row < 0 || row >= board.length
                || column < 0 || column >= board[0].length
                || this.board[row][column] != word.charAt(wordIndex))
            return false;

        boolean ret;
        board[row][column] = '$';

        ret = backtrack(row + 1, column, wordIndex + 1)
                || backtrack(row - 1, column, wordIndex + 1)
                || backtrack(row, column+1, wordIndex + 1)
                || backtrack(row, column-1, wordIndex + 1) ;

        this.board[row][column] = word.charAt(wordIndex);
        return ret;

    }
}
