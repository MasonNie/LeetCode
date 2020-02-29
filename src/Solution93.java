
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s.isEmpty()) return res;
        StringBuilder sb = new StringBuilder(s);
        builder(res,1,sb,3,sb.charAt(0)-'0');
        return res;
    }
    private void builder(List<String> res,int pos,StringBuilder sb,int dot,int num){
        if (dot<0) return;
        if (num>255) return;
        if (pos == sb.length()) {
            String tmp = sb.toString();
            if (dot==0&&isIPLegal(tmp)){
                res.add(tmp);
            }
            return;
        }
        sb.insert(pos,'.');
        builder(res, pos+2, sb, dot-1, sb.charAt(pos+1)-'0');
        sb.deleteCharAt(pos);
        builder(res, pos+1, sb, dot, num*10+sb.charAt(pos)-'0');
    }
    private  boolean isIPLegal(String ipStr){
        if(ipStr.isEmpty())
            return false;
        String regex = "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$";

        // 匹配1 和匹配2均可实现Ip判断的效果
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(ipStr).matches();
    }




    public static void main(String[] args) {
        System.out.println(new Solution93().restoreIpAddresses("0000"));
        System.out.println(new Solution93().isIPLegal("0.00.0.0"));

    }

}
