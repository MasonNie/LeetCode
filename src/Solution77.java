import java.util.LinkedList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> data = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            data.add(i);
        }
        backtrack(res,new LinkedList<Integer>(),data,k);
        return res;
    }
    private void backtrack(List<List<Integer>> res,List<Integer> path,List<Integer> data,int k){
        if (k == 0) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (data.isEmpty()) return; //顺序不能出错，如果先判断isEmpty会导致缺少最后元素

        path.add(data.get(0));
        backtrack(res, path, data.subList(1,data.size()), k-1);
        path.remove(path.size()-1);
        backtrack(res, path, data.subList(1,data.size()), k);

    }

    public static void main(String[] args) {
        System.out.println(new Solution77().combine(0,1));
    }
}
