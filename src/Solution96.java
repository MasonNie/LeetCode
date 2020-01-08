public class Solution96 {
    public int numTrees(int n) {
        if (n==0) return 1;
        int[] dp = new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i < n+1; i++) { //F(i,n)=G(i-1)*G(n-i) 因为 G{1,2,3,4}=G{4,5,6,7}
            for (int j = 1; j < i+1; j++) {//G(n)=ΣG(i-1)*G(n-i)
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution96().numTrees(10));
    }
}
