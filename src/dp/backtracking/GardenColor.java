package dp.backtracking;

import java.util.Arrays;

public class GardenColor {
    int[][] adjacencyMatrix;

    public void colorGarden(int n, int[][] paths, int colors) {
        int [] ans = new int [n];
        if(paths.length<1 || paths[0].length==0){
            Arrays.fill(ans, 1);
            System.out.println(Arrays.toString(ans));
            return;
        }
        adjacencyMatrix = new int[n][n];
        for (int[] p : paths) {
            adjacencyMatrix[p[0]][p[1]] = 1;
            adjacencyMatrix[p[1]][p[0]] = 1;
        }
        if(assignColor(ans, 0, colors)){
            System.out.println(Arrays.toString(ans));
        }
        else
            System.out.println("Not possible");
    }

    private boolean assignColor(int[] ans, int gardenIndex, int colors) {
        if (gardenIndex == ans.length) {
            return true;
        }
        for (int colorIndex = 1; colorIndex <= colors; ++colorIndex) {
            if (validColor(gardenIndex, colorIndex, ans)) {
                ans[gardenIndex]= colorIndex;
                if(assignColor(ans, gardenIndex+1, colors))
                    return true;
            }
        }
        return false;
    }

    private boolean validColor(int gardenIndex, int colorIndex, int[] ans) {
        for(int i=0; i<ans.length; i++){
            if(adjacencyMatrix[gardenIndex][i]==1 && ans[i]==colorIndex)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GardenColor gardenColor = new GardenColor();
        int [] [] paths = {
                {1,2},
                {0,2},
                {3,1},
                {3,0},
                {1,0}
        };

        gardenColor.colorGarden(4, paths, 3);
    }
}
