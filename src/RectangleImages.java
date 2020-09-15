import java.util.ArrayList;
import java.util.List;

public class RectangleImages {

    public String findRectangle(int [] [] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        StringBuilder sb = new StringBuilder();
        int length= 0, depth=0;
        for(int i=0; i<row; ++i){
            for(int j=0; j<col; ++j){
                if(matrix[i][j]==0){
                    sb.append("x="+j+" ");
                    sb.append("y="+i);
                    int prev = j;
                    j++;
                    while(j<col&& matrix[i][j]==0){
                        length++;
                        j++;
                    }
                    j=prev;
                    i++;
                    while(i<row&& matrix[i][j]==0){
                        depth++;
                        i++;
                    }
                    sb.append("width= "+ (length+1));
                    sb.append("height= "+ (depth+1));
                    break;
                }
            }
        }
        return sb.toString();
    }


    public List<String> findRectangles(int [] [] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean [][] visited = new boolean [row] [col];
        StringBuilder sb = new StringBuilder();
        int length= 0, depth=0;

        List<String> ans = new ArrayList<>();

        for(int i=0; i<row; ++i){
            for(int j=0; j<col; ++j){
                if(visited[i][j])
                    break;
                if(matrix[i][j]==0 && !visited[i][j]){
                    visited[i][j] = true;
                    sb.append("x="+j+" ");
                    sb.append("y="+i+ " ");
                    int prevCol = j;
                    int prevRow = i;
                    j++;
                    while(j<col&& matrix[i][j]==0 && !visited[i][j]){
                        length++;
                        visited[i][j] = true;
                        j++;
                    }
                    j=prevCol;
                    i++;
                    while(i<row&& matrix[i][j]==0 && !visited[i][j]){
                        depth++;
                        visited[i][j] = true;
                        i++;
                    }
                    sb.append("width= "+ (length+1)+" ");
                    sb.append("height= "+ (depth+1)+" ");
                    ans.add(sb.toString());
                    sb= new StringBuilder();
                    i=prevRow;
                    length=0;
                    depth=0;
                }
            }
        }
        return ans;
    }



    public static void main(String[] argv) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };


        RectangleImages solution = new RectangleImages();
        System.out.println(solution.findRectangles(image1));
        System.out.println(solution.findRectangles(image2));
        System.out.println(solution.findRectangles(image3));
        System.out.println(solution.findRectangles(image4));
    }
}
