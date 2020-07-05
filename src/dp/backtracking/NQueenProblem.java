package dp.backtracking;

public class NQueenProblem {
    public void placeQueens(int n, int [] [] chess){
        if(placeQueen(0, chess, n)) {
            display(chess);
        }else{
            System.out.println("No solution");
        }
    }

    private void display(int[][] chess) {
        for(int i=0; i<chess.length;++i){
            for (int j=0; j<chess.length; ++j){
                if(chess[i][j]==1){
                    System.out.print(" | ");
                }
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }

    private boolean placeQueen(int column, int[][] chess, int n) {
        if(column==n)
            return true;
        for(int row = 0; row<n ; ++row){
            if(canBePlaced(chess, row, column)){
                chess[row][column]=1;
                if(placeQueen(column+1, chess, n)){
                    return true;
                }
                chess[row][column]=0;
            }
        }
        return false;
    }

    private boolean canBePlaced(int[][] chess, int row, int column) {
        for(int i=0; i<column;++i){
            if(chess[row][i]==1) return false;
        }
        for(int i=row, j=column; i>=0 && j>=0;--i,--j){
            if(chess[i][j]==1) return false;
        }
        for(int i=row, j=column; i<chess.length && j>=0;++i,--j){
            if(chess[i][j]==1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueenProblem queenProblem = new NQueenProblem();
        queenProblem.placeQueens(4, new int[4][4]);
    }
}
