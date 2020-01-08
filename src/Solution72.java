public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i==0){
                    dp[i][j]=j;
                    continue;
                }
                if (j==0){
                    dp[i][j]=i;
                    continue;
                }
                int a=dp[i-1][j],b=dp[i][j-1],c=dp[i-1][j-1]-1;
                if (word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=Math.min(a,Math.min(b,c))+1;
                else {
                    c = c + 1;
                    dp[i][j] =Math.min(a,Math.min(b,c))+1;
                }
            }

        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance("horse","ros"));
    }
}
