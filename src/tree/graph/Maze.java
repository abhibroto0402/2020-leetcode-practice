package tree.graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {
    List<Pair<Integer, Integer>> neighbours = new ArrayList<>();

    Maze() {
        neighbours.add(new Pair<>(1, 0));
        neighbours.add(new Pair<>(-1, 0));
        neighbours.add(new Pair<>(0, 1));
        neighbours.add(new Pair<>(0, -1));

    }

    int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }

    boolean dfs(int[][] maze, int row, int col, int[] destination, boolean[][] visited) {
        if (visited[row][col])
            return false;

        if (row == destination[0] && col == destination[1]) {
            return true;
        }

        visited[row][col] = true;

        for (int[] dir: dirs) {
            int nr = row;
            int nc = col;
            while (isValid(nr + dir[0], nc + dir[1], maze)) {
                nr += dir[0];
                nc += dir[1];
            }
            if (dfs(maze, nr, nc, destination, visited))
                return true;
        }
        return false;
    }

    boolean isValid(int row, int col, int[][] maze) {
        if (row < 0 || row >= maze.length)
            return false;

        if (col < 0 || col >= maze[0].length)
            return false;

        return maze[row][col] != 1;
    }

    public static void main(String[] args) {
//        Maze maze = new Maze();
//        int[][] arr = new int[][]{
//                {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}
//        };
//
//        System.out.println(maze.hasPath(arr, new int[]{0, 4}, new int[]{4, 4}));

        Random random = new Random();
        for(int i=0; i<10 ; ++i)
            System.out.println(random.nextInt(4));
    }
}
