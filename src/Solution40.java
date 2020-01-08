import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len==0) return res;
        Arrays.sort(candidates);
        backtrack(res,candidates,target,0,new ArrayList<>());
        return res;
    }
    void backtrack(List<List<Integer>> res,int[] candidates,int target,int start,List<Integer> path){
        if (target<0) return;
        else if (target==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        else {
            for (int i=start;i<candidates.length;i++){
                if (i>start&&candidates[i-1]==candidates[i]) continue;
                path.add(candidates[i]);
                backtrack(res, candidates, target-candidates[i], i+1, path);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] in = {10,1,2,7,6,1,5};
        List<List<Integer>> out = new Solution40().combinationSum2(in,8);
        System.out.println(out);
    }

}
