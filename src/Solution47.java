import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //int len = nums.length;
        int[] pos = new int[nums.length];
        Arrays.sort(nums);
        backtrack(res,nums,new ArrayList<>(),pos,0,-1);
        return res;
    }
    void backtrack(List<List<Integer>> res,int[] nums,List<Integer> path,int[] pos,int start,int last){
        if (start == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (pos[i]==1)continue;
            if (i>0&&nums[i-1]==nums[i]&&pos[i-1]>0) continue;
            pos[i]=1;
            path.add(nums[i]);
            backtrack(res, nums, path, pos,start+1,nums[i]);
            path.remove(path.size()-1);
            pos[i]=0;

        }


    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        List<List<Integer>> out = new Solution47().permuteUnique(a);
        System.out.println(out);
    }
}
