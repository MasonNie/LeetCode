import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new LinkedList<>();
//        if (s.isEmpty()||wordDict.size()==0) return res;
//        backtrack(res,s,wordDict,"");
        return memoBacktrack(s,wordDict,0,new HashMap<>());
    }
    void backtrack(List<String> res,String s, List<String> wordDict,String path){
        if (s.isEmpty()) {
            res.add(path.substring(0,path.length()-1));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.indexOf(s.substring(0,i+1))!=-1){
                path = path + s.substring(0,i+1) + " ";
                backtrack(res, s.substring(i+1), wordDict,path);
                path = path.substring(0,path.length()-(i+2));
            }
        }
    }
    List<String> memoBacktrack(String s, List<String> wordDict, int start, HashMap<Integer,List<String>> map){
        if (map.containsKey(start)){
            return map.get(start);
        }
        List<String> res = new LinkedList<>();
        if (start==s.length()){
            res.add("");
        }
        for (int end = start; end < s.length(); end++) {
            if (wordDict.contains(s.substring(start,end+1))){
                List<String> list = memoBacktrack(s, wordDict, end+1, map);
                for (String l:list) {
                    res.add(s.substring(start,end+1)+(l.equals("")?"":" ")+l);
                }
            }
        }
        map.put(start,res);
        return res;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        String[] add = { "cat", "cats", "and", "sand", "dog"};
        for (int i = 0; i < add.length; i++) {
            wordDict.add(add[i]);
        }
        String s = "catsanddog";
        System.out.println(new Solution140().wordBreak(s,wordDict));
    }
}
