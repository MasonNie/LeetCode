public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        if (l1+l2!=l3) return  false;
        return dp(s1,s2,s3);
    }
    boolean backtrack(String s1, String s2, String s3,int idx1,int idx2,String res){
        if (s3.equals(res)) return true;
        boolean now = false;
        if (idx1<s1.length()) now |= backtrack(s1, s2, s3, idx1+1, idx2, res+s1.charAt(idx1));
        if (idx2<s2.length()) now |= backtrack(s1, s2, s3, idx1, idx2+1, res+s2.charAt(idx2));
        return now;
    }

    boolean dp(String s1, String s2, String s3){
        int l1=s1.length(),l2=s2.length(),l3=s3.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i==0&&j==0){
                    dp[i][j] = true;
                }else if (i==0){
                    dp[i][j] = dp[i][j-1]&& s2.charAt(j-1)==s3.charAt(i+j-1);
                }else if (j==0){
                    dp[i][j] = dp[i-1][j]&& s1.charAt(i-1)==s3.charAt(i+j-1);
                }else {
                    dp[i][j] = dp[i][j-1]&& s2.charAt(j-1)==s3.charAt(i+j-1) || dp[i-1][j]&& s1.charAt(i-1)==s3.charAt(i+j-1);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution97().isInterleave("cabbcaaacacbac",
                "acabaabacabcca",
                "cacabaabacaabccbabcaaacacbac"));
    }
}
