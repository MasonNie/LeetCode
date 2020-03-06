import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution60 {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //递归求解
        return builder(list,n,jieCheng(n-1),k-1); //传参k-1不是k，是因为builder中的k从0开始计数，而题目中的k从1开始计数
    }
    private int jieCheng(int n){
        int res = 1;
        for (int i = 2; i <=n ; i++) {
            res *= i;
        }
        return res;
    }

    /**
     *
     * @param list 剩余数字的容器
     * @param n 多少个数
     * @param jieC 一组多少个数
     * @param k 第几个
     * @return 第k个数的结果
     */
    String builder(LinkedList<Integer> list,int n,int jieC,int k){
        if (list.size()==1){
            return String.valueOf(list.get(0));
        }
        int zu = (k)/jieC;
        int offset = (k)%jieC;
        return String.valueOf(list.remove(zu)) + builder(list,n-1,jieCheng(n-2),offset);
    }

    public static void main(String[] args) {

        System.out.println(new Solution60().getPermutation(9,2));

    }
}
