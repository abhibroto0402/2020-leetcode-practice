package dp.backtracking;

import java.util.Arrays;

public class KnightsTour {
    int[] x_moves = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] y_moves = {1, 2, 2, 1, -1, -2, -2, -1};
    int N=0;
    int [] [] chessboard;

    public void solveKnightsTour(int[][] chessboard) {
        this.chessboard=chessboard;
        N= chessboard.length;
        for (int i = 0; i < N ; ++i)
            Arrays.fill(chessboard[i], Integer.MIN_VALUE);
        chessboard[0][0] = 1;
        if (makeMove(2, 0, 0)) {
            display(chessboard);
        } else
            System.out.println("No solution");

    }

    private void display(int [] [] chessboard){
        for(int i=0; i< N;++i){
            for(int j=0; j<N;++j){
                System.out.print(chessboard[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private boolean makeMove(int stepCount, int x, int y) {
        if(stepCount==N*N+1)
            return true;
        for(int i=0; i<x_moves.length;++i){
            int next_x = x + x_moves[i];
            int next_y = y +y_moves[i];
            if(isValidMove(next_x, next_y)){
                chessboard[next_x][next_y]= stepCount;
                if(makeMove(stepCount+1, next_x, next_y)){
                    return true;
                }
                chessboard[next_x][next_y]= Integer.MIN_VALUE;
            }
        }
        return false;
    }

    private boolean isValidMove(int x, int y) {
        if(x<0 || x>=N) return false;
        if(y<0 || y>=N) return false;
        return chessboard[x][y]==Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        KnightsTour knightsTour = new KnightsTour();
        knightsTour.solveKnightsTour(new int[8][8]);
    }
}
