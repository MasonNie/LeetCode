import java.util.LinkedList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length==0) return res;
        int r1 = 0,r2 = matrix.length-1;
        int c1 = 0,c2 = matrix[0].length-1;
        while (r1<=r2&&c1<=c2){
            for (int j = c1; j < c2+1; j++) {
                res.add(matrix[r1][j]);
            }
            for (int i = r1+1; i < r2+1; i++) {
                res.add(matrix[i][c2]);
            }
            if (r1<r2&&c1<c2){ //这一步确定数据不是一行，确定是四边形
                for (int j = c2-1; j > c1; j--) {
                    res.add(matrix[r2][j]);
                }
                for (int i = r2; i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }
            c1++;c2--;
            r1++;r2--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] a = {{ 1, 2, 3 },
 { 4, 5, 6 },
 { 7, 8, 9 }};
        int[][] b = {{ 1, 2, 3, 4 },
                { 5, 6 ,7 ,8 },
                { 9,10,11,12}};
        int[][] c = {{1,2,3}};
        System.out.println(new Solution54().spiralOrder(a));
    }
}
