import java.util.LinkedList;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        if (newInterval.length!=2) return intervals;
        LinkedList<int[]> ints_set = new LinkedList();
        boolean flag = true; //表示是不是区间还能添加，true表示没添加过，false表示添加过了
        if (intervals[0][0]>=newInterval[0]) ints_set.add(newInterval); //处理第一个
        for (int i = 0; i < intervals.length; i++) {
            if (flag&&intervals[i][0]>newInterval[0]) {
                ints_set.add(newInterval);
                flag = false;
                merge(ints_set);
            }
            ints_set.add(intervals[i]);
            if (ints_set.size()>1) merge(ints_set);
        }
        if (flag) { //处理是不是添加到最后边
            ints_set.add(newInterval);
            merge(ints_set);
        }
        int[][] res = new int[ints_set.size()][2];
        return ints_set.toArray(res);
    }
    void merge(LinkedList<int[]> ints_set){
        if (ints_set.getLast()[0]<=ints_set.get(ints_set.size()-2)[1]){
            ints_set.get(ints_set.size()-2)[1] = Math.max(ints_set.getLast()[1],ints_set.get(ints_set.size()-2)[1]);
            ints_set.removeLast();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,3},{6,9}};
        int[][] b = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] out = new Solution57().insert(b,new int[]{17,20});
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                System.out.print(out[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
