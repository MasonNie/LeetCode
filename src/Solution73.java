import java.util.Arrays;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length,n = matrix[0].length;

        boolean[] row = new boolean[m],col = new boolean[n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0){
                    row[r] = true;
                    col[c] = true;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            if (row[r]) Arrays.fill(matrix[r],0);
        }
        for (int c = 0; c < n; c++) {
            if (col[c]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][c] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        int[][] b = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        //a = b;
        new Solution73().setZeroes(new int[2][0]);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
