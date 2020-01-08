public class Solution132 {
    public int minCut(String s) {
        int size = s.length();
        if (size==0) return 0;
        int[] qie = new int[size];
        for (int i = 0; i < size; i++) {
            qie[i] = i;
        }
        boolean[][] dp = new boolean[size][size];
        for (int i = size-1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if (s.charAt(i)==s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    //System.out.println(j);
                }
                else
                    dp[i][j] = false;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (dp[i][j]){
                    if (i==0) qie[j] = 0;
                    else qie[j] = Math.min(qie[j],qie[i-1]+1);
                }

            }
        }

        return qie[size-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution132().minCut("aab"));
    }
}
