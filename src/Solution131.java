import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s.isEmpty()) return res;
        if (s.length()==1) {
            res.add(Arrays.asList(s));
            return res;
        }
        builder(res,new LinkedList<>(),s,1);
        return res;
    }

    private void builder(List<List<String>> res,LinkedList<String> path,String s,int pos) {
        if (pos == s.length()) {
            if (isPalindrome(s)) {
                path.add(s);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }
        if (s.isEmpty()){
            return;
        }
        //分割
        if (isPalindrome(s.substring(0,pos))){
            path.add(s.substring(0,pos));
            builder(res, path, s.substring(pos), 1);
            path.removeLast();
        }
        //不分割
        builder(res, path, s, pos+1);

    }

    private boolean isPalindrome(String substring) {
        int len = substring.length();
        if (len==1) return true;
        for (int i = 0; i < (len>>1); i++) {
            if (substring.charAt(i)!=substring.charAt(len-1-i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aab"));
    }

}
