import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
//        List in = Arrays.asList(nums);
//        for (int i = 0; i < nums.length; i++) {
//            swap(nums,0,i);
//            //builder
//            swap(nums,0,i);
//        }
        builder(nums,0,res,new LinkedList<Integer>());
        return res;
    }
    private void builder(int[] nums,int start,List<List<Integer>> res,List<Integer> path){
        if (start == nums.length){
            res.add(new LinkedList<Integer>(path));
            return;
        }
        //add
        path.add(nums[start]);
        builder(nums, start+1, res, path);
        //No-add
        path.remove(path.size()-1);
        builder(nums, start+1, res, path);

    }
    private void swap(int[] nums,int a,int b){
        if (a == b) return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(new Solution78().subsets(new int[0]));
    }
}
