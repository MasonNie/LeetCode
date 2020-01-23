public class Solution65 {
    private int pos = 0;
    public boolean isNumber(String s) {
        s = s.trim(); //去空格
        if (s.isEmpty()) return false;
        boolean res = scanNumber(s,pos);

        if (pos<s.length()&&s.charAt(pos) == '.'){
            pos += 1;
            res =scanOnlyNumber(s,pos)  || res;
        }
        if (pos<s.length()-1&&s.charAt(pos) == 'e'){
            pos += 1;
            res = res && scanNumber(s,pos);
        }
        return res && pos==s.length();
    }
    private boolean scanOnlyNumber(String s,int pos){
        int mark = pos;
        while (pos<s.length()&& s.charAt(pos)>='0'&&s.charAt(pos)<='9')
            pos += 1;
        this.pos = pos;
        return pos>mark;
    }
    private boolean scanNumber(String s,int pos){
        if (s.charAt(pos) == '+' || s.charAt(pos) == '-')
            pos += 1;
        this.pos = pos;
        return scanOnlyNumber(s,pos);
    }

    public static void main(String[] args) {
        System.out.println(new Solution65().isNumber("0e "));
    }
}
