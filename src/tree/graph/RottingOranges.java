package tree.graph;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    class Node{
        int time;
        int x,y;

        Node(int time, int x, int y){
            this.time=time;
            this.x=x;
            this.y=y;
        }
    }
    int last=0;
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int row = grid.length;
        int col= grid[0].length;
        for(int i=0;i<row; ++i){
            for(int j=0; j<col; ++j){
                if(grid[i][j]==2){
                    q.add(new Node(0, i, j));
                }
            }
        }
        bfs(grid,q);
        for(int i=0;i<row; ++i){
            for(int j=0; j<col; ++j){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return last;
    }
    private void bfs(int [] [] grid, Queue<Node> q){
        while(!q.isEmpty()){
            Node source = q.poll();
            last=source.time;
            int row = source.x;
            int col = source.y;
            if(row-1>=0 && grid[row-1][col]==1){
                grid[row-1][col]=2;
                q.add(new Node(source.time+1, row-1, col));
            }
            if(col-1>=0 && grid[row][col-1]==1){
                grid[row][col-1]=2;
                q.add(new Node(source.time+1, row, col-1));
            }
            if(row+1<grid.length && grid[row+1][col]==1){
                grid[row+1][col]=2;
                q.add(new Node(source.time+1, row+1, col));
            }
            if(col+1<grid[0].length && grid[row][col+1]==1){
                grid[row][col+1]=2;
                q.add(new Node(source.time+1, row, col+1));
            }
        }
    }
}
