package tree.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
    List<Pair<Integer, Integer>> coord = new ArrayList<>();
    NumberOfIslands(){
        this.coord.add(new Pair<>(0,1));
        this.coord.add(new Pair<>(0,-1));
        this.coord.add(new Pair<>(1,0));
        this.coord.add(new Pair<>(-1,0));
    }
    char [] [] mat;
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols= grid[0].length;
        int count=0;
        mat=grid;
        for(int i=0; i<rows; ++i){
            for(int j=0;j<cols; ++j){
                if(grid[i][j]=='1'){
                    ++count;
                    dfs(i, j, rows, cols);
                }
            }
        }
        print(mat);
        return count;
    }

    private void dfs(int i, int j, int rows, int cols){
        if(i<0 || j<0 || i>=rows || j>=cols || mat[i][j]!='1')
            return;
        mat[i][j]='2';
        for(Pair<Integer, Integer> entry: coord){
            dfs(i+entry.getKey(), j+entry.getValue(), rows, cols);
        }
    }

    private void print(char [] [] grid){
        for(char [] rows: grid){
            for(char c: rows){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char [] [] arr = {
                {'1','1','1','0','0'},
                {'1','0','1','0','0'},
                {'1','0','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','1','0','0'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(arr));
    }
}
