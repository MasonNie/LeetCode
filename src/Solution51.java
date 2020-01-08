import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res,n,new ArrayList<>(),0);
        return res;

    }
    void backtrack(List<List<String>> res,int n,List<String> path,int pos){
        if (!check(n,path)){
            return;
        }
        if (path.size()==n){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if (j==i) s = s + "Q";
                else s = s + ".";
            }
//            StringBuilder sb = new StringBuilder(s);
//            sb.setCharAt(i,'Q');
            path.add(s);
            backtrack(res, n, path, i);
            path.remove(path.size()-1);
        }

    }
    boolean check(int n,List<String> path){
        int size = path.size();
        if (size == 0) return true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < size; j++) {
                if (path.get(j).charAt(i)!='Q') continue;
                else {
                    for (int k = j+1; k < size; k++) {
                        for (int l = 0; l < n; l++) {
                            char tmp = path.get(k).charAt(l);
                            if (path.get(k).charAt(i)=='Q') return false;
                            if (tmp=='Q'&&k-l==j-i) return false;
                            if (tmp=='Q'&&k+l==j+i) return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Solution51 sol = new Solution51();
        List<String> in = new ArrayList<>();
        in.add(".Q..");
        in.add("...Q");
        in.add("..Q.");
        System.out.println(sol.check(4,in));
        System.out.println(sol.solveNQueens(1));
    }
}
