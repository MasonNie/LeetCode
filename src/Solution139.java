import java.util.ArrayList;
import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int size = s.length();
        if (size==0||wordDict.size()==0) return false;
        boolean[] dp = new boolean[size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (j==0) dp[i] = wordDict.indexOf(s.substring(0,i+1))!=-1;
                else if (wordDict.indexOf(s.substring(j,i+1))!=-1&&dp[j-1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[size-1];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        String[] add = { "dog", "sand", "and", "cat"};
        for (int i = 0; i < add.length; i++) {
            wordDict.add(add[i]);
        }
        String s = "catsanddog";
        System.out.println(wordDict.indexOf(s.substring(3)));
        System.out.println(new Solution139().wordBreak(s,wordDict));
    }
}
