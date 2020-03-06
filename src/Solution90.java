import java.util.*;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
//        LinkedList<Integer> list_nums = new LinkedList<>();
//        Map<List<Integer>,Boolean> used = new HashMap<>();
        Arrays.sort(nums);
//        for (int num : nums) {
//            list_nums.add(num);
//        }
//        builder(res,list_nums,new ArrayList<>(),used);
        kuaiSu(res,nums,0,new LinkedList<>());
        return res;
    }
    private void builder(List<List<Integer>> res, List<Integer> list_nums, List<Integer> path, Map<List<Integer>, Boolean> used){
        if (list_nums.size() == 0){
            if (res.isEmpty()){
                res.add(new ArrayList<>(path));
                used.put(res.get(res.size()-1),true);
            }
            else if (!used.containsKey(path)){
                res.add(new ArrayList<>(path));
                used.put(res.get(res.size()-1),true);
            }
            return;
        }
        //Add
        path.add(list_nums.get(0));
        builder(res, list_nums.subList(1,list_nums.size()), path,used);
        //No-Add
        path.remove(path.size()-1);
        builder(res, list_nums.subList(1,list_nums.size()), path,used);
    }

    private void kuaiSu(List<List<Integer>> res,int[] nums,int pos,List<Integer> path){
        res.add(new LinkedList<>(path));
        for (int i = pos; i < nums.length; i++) {
            if (i>pos&&nums[i]==nums[i-1])
                continue;
            path.add(nums[i]);
            kuaiSu(res, nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,2,2,1};
        int[] in = a;
        System.out.println(new Solution90().subsetsWithDup(in));
    }
}
