import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows<=0) return res;
        res.add(Arrays.asList(1));
        if (numRows==1) return res;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i-1; j++) {
                tmp.add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
            }
            tmp.add(1);
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution118().generate(5));
    }

}
