import java.util.Arrays;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0) return 0;
        int m=matrix.length,n=matrix[0].length,max=0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        for (int i = 0; i < m; i++) {
            int cur_left = 0,cur_right = n;
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j]=='1'?height[j] + 1 : 0 ;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='1'){
                    left[j] = Math.max(cur_left,left[j]);
                }else{
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n-1; j >=0 ; j--) {
                if (matrix[i][j]=='1'){
                    right[j] = Math.min(right[j],cur_right);
                }
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                int area = height[j]*(right[j]-left[j]);
                if (max<area){
                    max = area;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        char[][] in = {
  {'1','0','1','0','0'},
  {'1','0','1','1','1'},
  {'1','1','1','1','1'},
  {'1','0','0','1','0'}
};

        System.out.println(new Solution85().maximalRectangle(in));
    }
}
