import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    List<String> res = new ArrayList<>();
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    void backtrack(String combine,String next_digit,int len){
        if (combine.length()==len){
            res.add(combine);
        }
        else {
            String digit = next_digit.substring(0,1);
            String letters = phone.get(digit);
            for (int i=0;i<letters.length();i++){
                String letter = letters.substring(i,i+1);
                backtrack(combine+letter,next_digit.substring(1),len);
            }

        }

    }
    public List<String> letterCombinations(String digits) {
        backtrack("",digits,digits.length());
        return res;

    }
    public static void main(String[] args) {
        letterCombinations l = new letterCombinations();
        List<String> out = l.letterCombinations("23");
        System.out.println(out);
    }
}
