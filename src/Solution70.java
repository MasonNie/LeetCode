public class Solution70 {
    int res=0;
    public int climbStairs(int n) {
        if (n==1) return 1;
        int []dp=new int[n+1];
        dp[1]=1;dp[2]=2;
        for (int i = 3; i < n+1; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];


    }
    void backtrack(int n){
        if (n==0) {
            res+= 1;
            return;
        }
        if (n<0){
            return;
        }

        for (int i=1;i<3;i++){
            backtrack(n-i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution70().climbStairs(44));
    }
}
