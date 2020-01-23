public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (matrix[0][0] == target) return true;
        else if (matrix[0][0] > target) return false;
        //也可以直接二分法，对最后一列二分，再二分
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;
            else if (matrix[i][0] > target) return erFen(matrix[i-1],target);
        }

        return erFen(matrix[matrix.length-1],target); //前面都没有，是否在最后一行
    }
    private boolean erFen(int[] hang,int target){
        int l = 0,r = hang.length-1;
        while (l <= r){
            int mid = (l + r)>>1;
            if (hang[mid] == target) return true;
            else if (hang[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[][] b = {
                {}
        };
        int[][] in = a;
        //System.out.println(b.length + " " +b[0].length);
        System.out.println(new Solution74().searchMatrix(in,50));
    }
}
