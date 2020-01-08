public class Solution123 {
    public int maxProfit(int[] prices) {
        int K = 2,len = prices.length;
        if (len==0) return 0;
        int dp[][][] = new int[len][K+1][2];
        for (int i = 0; i < len; i++) {
            for (int j = K; j >= 1; j--) {
                if (i==0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0]-prices[i],dp[i-1][j][1]);
            }
        }
        return dp[len-1][K][0];
    }

    public static void main(String[] args) {
        int[] a = {3,3,5,0,0,3,1,4};
        System.out.println(new Solution123().maxProfit(a));
    }
    
}
