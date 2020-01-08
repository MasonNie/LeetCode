public class Solution44 {
    public boolean isMatch(String s, String p) {
        int len_s=s.length(),len_p=p.length();
        //字符串索引从0开始，但是dp中的i，j代表长度，从1开始,所以charAt中的索引都减一
        boolean[][] dp = new boolean[len_s+1][len_p+1];
        dp[0][0]=true;
        for (int i = 1; i < len_p+1; i++) {
            if (p.charAt(i-1)=='*') dp[0][i]=dp[0][i-1];
        }
        for (int i = 1; i < len_s+1; i++) {
            for (int j = 1; j < len_p+1; j++) {
                if (p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if (p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[len_s][len_p];
    }
    boolean test(String text,String pattern){
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // dp[len][len] 代表两个空串是否匹配了，"" 和 "" ，当然是 true 了。
        dp[text.length()][pattern.length()] = true;

        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                // dp[text.length()][pattern.length()] 已经进行了初始化
                if (i == text.length() && j == pattern.length())
                    continue;
                //相比之前增加了判断是否等于 *
                boolean first_match = (i < text.length() && j < pattern.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '?' || pattern.charAt(j) == '*'));
                if (j < pattern.length() && pattern.charAt(j) == '*') {
                    //将 * 跳过 和将字符匹配一个并且 pattern 不变两种情况
                    dp[i][j] = dp[i][j + 1] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];


    }
    boolean piPei(String s,String p){
        if (p.length()==0) return s.length()==0;
        if (s.length()==0) {
            if (p.length()>0&&p.charAt(0)=='*') return piPei(s, p.substring(1));
            else return false;
        }
        if (p.charAt(0)=='?'){
            if (s.length()==0) return false;
            else return isMatch(s.substring(1),p.substring(1));
        }
        else if (p.charAt(0)=='*'){
            return piPei(s.substring(1),p)||piPei(s,p.substring(1));
        }
        else {
            if (s.charAt(0)!=p.charAt(0)) return false;
            else return piPei(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s="aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
        String p="*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
        //s="aaaa";p="*a**";

        boolean out = new Solution44().isMatch(s,p);
        System.out.println(out);
    }
}
