import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String,List> map = new HashMap();
        if (len==0) return new ArrayList<>();
        for (String str:strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> out = new Solution49().groupAnagrams(a);
        System.out.println(out);
    }
}
