public class Solution91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        if (s.charAt(0)=='0') return 0;
        dp[1] = 1;
        if (s.charAt(0)-'0'>2) dp[2] = 1;
        else if (s.charAt(1)-'0'>6||s.charAt(1)=='0') dp[2] = 1;
        else dp[2] = 2;

        for (int i = 3; i < len+1; i++) {
            if (s.charAt(i)=='0'){
                if (s.charAt(i-1)-'0'>2||s.charAt(i-1)=='0') return 0;
            }
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(new Solution91().numDecodings("10"));
    }

}
