public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        int l=0,r=sb.length()-1;
        while (l<r){
            if (charVaild(sb.charAt(l))){
                if (charVaild(sb.charAt(r))){
                    if (sb.charAt(l)!=sb.charAt(r)){
                        return false;
                    }else {
                        l++;
                        r--;
                    }
                }else
                    r--;
            }else
                l++;
        }
        return true;
//        for (int i = 0; i < sb.length(); i++) {
//            if (!charVaild(sb.charAt(i))){
//                sb.deleteCharAt(i);
//                i--;
//            }
//        }
        //return vaild(sb);
    }

    private boolean charVaild(char charAt) {
        if (charAt>='a'&&charAt<='z') return true;
        else if (charAt>='0'&&charAt<='9') return true;
        return false;
    }

    private boolean vaild(StringBuilder sb){
        int length = sb.length();
        for (int i = 0; i < length/2; i++) {
            if (sb.charAt(i)!=sb.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "race a car";
        String b = "A man, a plan, a canal: Panama";
        String in = b;
        System.out.println(new Solution125().isPalindrome(in));
    }
}
