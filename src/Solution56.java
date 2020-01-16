import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<Integer> idx_set =new LinkedList<Integer>();
        int len = intervals.length;
        if (len==0) return new int[0][2];
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < len; i++) {
            if (intervals[i][0]>intervals[i-1][1]) idx_set.add(i-1);
            else {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i][1],intervals[i-1][1]);
            }
        }
//        if (intervals[len-1][0]>intervals[len-2][1])
        idx_set.add(len-1);
        int[][] res = new int[idx_set.size()][2];
        int i = 0;
        for (int idx:idx_set
             ) {
            res[i] = intervals[idx];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{5,6},{1,5},{3,4}};
        int[][] b = {{1,3},{2,6},{8,10},{15,18}};
        //Arrays.sort(a, (o1, o2) -> o1[0}-o2[0]);
        //Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        int[][] out = new Solution56().merge(b);
        for (int i = 0; i < out.length; i++) {
            System.out.println();
            for (int j = 0; j < out[0].length; j++) {
                System.out.print(out[i][j]+"\t");
            }
        }
    }
}
