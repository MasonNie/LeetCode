import java.util.ArrayList;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min_sum = Integer.MAX_VALUE;
        if (triangle.size()==0) return 0;

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i==0) ;
                else if (j==0)
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
                else if (j==triangle.get(i).size()-1)
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                else {
                    triangle.get(i).set(j,Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1))+triangle.get(i).get(j));
                }
                if (i==triangle.size()-1 ) min_sum = Math.min(min_sum,triangle.get(i).get(j));
            }
        }
        return min_sum;
    }

    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            in.add(new ArrayList<>());
        }
        in.get(0).add(2);
        in.get(1).add(3);in.get(1).add(4);
        in.get(2).add(6);in.get(2).add(5);in.get(2).add(7);
        in.get(3).add(4);in.get(3).add(1);in.get(3).add(8);in.get(3).add(3);
        System.out.println(new Solution120().minimumTotal(in));
    }
}
