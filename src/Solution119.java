import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex<1) return Arrays.asList(1);
        List<Integer> res = new ArrayList<>();
        int[][]dp = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (i==0) dp[i][j] = 1;
                else if (j==0) dp[i][j] = 1;
                else if (i==j) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.add(dp[rowIndex][i]);
        }
//        for (int i = 0; i <= rowIndex; i++) {
//            res.add(builder(rowIndex,i));
//        }
        return res;
    }

    private int builder(int i, int j) {
        if (i==0) return 1;
        if (j==0) return 1;
        if (i==j) return 1;
        return builder(i-1,j-1)+builder(i-1,j);
    }

    public static void main(String[] args) {
        //for (int i = 0; i < 10; i++) {
            System.out.println(new Solution119().getRow(60));
       // }

    }
}
