import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int top = 1;
        res.add(0);
        if (n==0) return res;
        for (int i = 0; i < n; i++) {
            for (int j = res.size()-1; j >= 0; j--) {
                res.add(top + res.get(j));
            }
            top = top << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution89().grayCode(0));
        System.out.println(new Solution89().grayCode(3));
    }
}
