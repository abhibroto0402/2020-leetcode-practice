package dp.backtracking;

public class MazeSolver {
    int [] [] maze;
    int [] [] solution;
    int len;
    MazeSolver (int [] [] maze){
        this.maze=maze;
        this.len= maze.length;
        solution = new int[len][len];
    }

    public void navigateMaze(){
        if(takeStep(0,0)){
            display(solution);
        }else{
            System.out.println("no solution");
        }
    }

    private boolean takeStep(int x, int y) {
        if(x==len-1 && y==len-1){
            solution[x][y]=1;
            return true;
        }
        if(isValidStep(x, y)){
            solution[x][y]=1;
            if(takeStep(x+1, y))
                return true;
            if(takeStep(x, y+1))
                return true;
            solution[x][y]=0;
        }
        return false;
    }

    private boolean isValidStep(int x, int y) {
        if(x<0 || x>=len) return false;
        if(y<0 || y>=len) return false;
        return maze[x][y]==0;
    }

    private void display(int[][] solution) {
        for(int i=0; i<len;++i){
            for (int j=0; j<len; ++j){
                if(solution[i][j]==1){
                    System.out.print(" S ");
                }
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [] [] maze = {
                {0,0,0,1},
                {1,1,0,1},
                {0,0,0,0},
                {1,1,0,0}
        };
        MazeSolver mazeSolver = new MazeSolver(maze);
        mazeSolver.navigateMaze();
    }
}
