package com.part;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length==0) return res;
        List<Integer> path = new ArrayList<Integer>();
        backtrack(res,candidates,target,0,path);
        return res;
    }
    void backtrack(List<List<Integer>> res,int[] candidates,int target,int idx,List<Integer> path){
        if (target<0) return;
        if (target==0){
            res.add(new ArrayList<>(path));
            return;

        }
        else {
            for (int i=idx;i<candidates.length;i++){
                path.add(candidates[i]);
                backtrack(res,candidates,target-candidates[i],i,path);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        List<List<Integer>> out = new CombinationSum().combinationSum(a,7);
        System.out.println(out);
    }
}
