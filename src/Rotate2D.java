public class Rotate2D {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Rotate2D rotate2D = new Rotate2D();
        int [] [] matrix= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate2D.rotate(matrix);
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix.length;++j){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
