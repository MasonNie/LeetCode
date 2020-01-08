import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //int len = nums.length;
        int[] pos = new int[nums.length];
        backtrack(res,nums,new ArrayList<>(),pos,0);
        return res;

    }
    void backtrack(List<List<Integer>> res,int[] nums,List<Integer> path,int[] pos,int start){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (pos[i]==1)continue;
            pos[i]=1;
            path.add(nums[i]);
            backtrack(res, nums, path, pos,start+1);
            path.remove(path.size()-1);
            pos[i]=0;
        }


    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        List<List<Integer>> out = new Solution46().permute(a);
        System.out.println(out);
    }
}
