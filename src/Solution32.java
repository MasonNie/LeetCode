public class Solution32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        int left=0,right=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(')
                left++;
            else right++;
            if (right>left){
                left = right = 0;
            }
            else if (right==left){
                int tmp = right+left;
                res = res>tmp?res:tmp;
            }
        }
        left = right = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)==')')
                right++;
            else left++;
            if (right<left){
                left = right = 0;
            }
            else if (right==left){
                int tmp = right+left;
                res = res>tmp?res:tmp;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        String a = "()()";
        int out = new Solution32().longestValidParentheses(a);
        System.out.println(out);
    }
}
