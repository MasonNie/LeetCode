import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        String res = "";
        if (s.length()==0||t.length()==0) return res;
        Map<Character,Integer> map = new HashMap<>();
        for (Character c : s.toCharArray())
            map.put(c,0);
        for (Character c : t.toCharArray()){
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else return res;
        }
        int l = 0,r = 0,count = t.length();
        while (r < s.length()){
            char c = s.charAt(r);
            if (map.get(c) > 0){
                count--;
            }
            map.put(c,map.get(c)-1);
            r++; //先自增，后边的subString就不需要(l,r+1)了
            //如果count==0，满足了t，判断是不是最短，并尝试移动left，缩短res
            while (count == 0 && l < r){
                if (res.length() == 0){ //初始化的情况
                    res = s.substring(l,r);
                }else if (res.length() > (r-l)){
                        res = s.substring(l,r);
                }
                char c_l = s.charAt(l);
                if (map.get(c_l)==0){
                    count++;
                }

                map.put(c_l,map.get(c_l)+1);
                l++;
            }
        }
        return res;
    }
    public String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, 0); //初始化s的字符，全部为key-0
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1); //t中出现的字符数 key-int
            } else {
                return "";
            }
        }
        String result = "";
        //记录需要被匹配的次数
        int count = t.length();
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //将字符进行匹配
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);
            right++;
            while (count == 0) {
                //替换最小结果
                if(result.length() == 0){
                    result = s.substring(left, right);
                }else if (result.length() > (right - left)) {
                    result = s.substring(left, right);
                }
                //移动左指针
                char c1 = s.charAt(left);
                if (map.get(c1) == 0) {
                    count++;
                }
                map.put(c1, map.get(c1) + 1);
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("cabwefgewcwaefgcf",
                "cae"));
    }
}
