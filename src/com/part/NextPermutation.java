package com.part;

public class NextPermutation {

    int zhaoNiXu(int[] nums){
        for (int i=nums.length-1;i>0;i--){
            if (nums[i-1]<nums[i]) {
                return i;
            }
        }
        return 0;
    }
    int chaZhao(int[] nums,int pos){
        int target = nums[pos-1];
        for (int i=pos;i<nums.length-1;i++){
            if (nums[i]>target&&nums[i+1]<=target) return i;
        }
        return nums.length-1;
    }

    void swap(int []nums,int pos1,int pos2){
        int tmp = 0;
        tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
    public void nextPermutation(int[] nums) {
        //先找从后往前的逆序
        if (nums.length<2) return;
        int pos = zhaoNiXu(nums);
        if (pos==0) {
            for (int i=0;i<nums.length/2;i++){
                swap(nums,i,nums.length-1-i);
            }
            return;
        }
        //再找逆序中比逆序结束后元素大的元素 修改为最小序列
        int bigger = chaZhao(nums,pos);
        swap(nums,bigger,pos-1);
        int l = pos,r = nums.length-1;
        while(l<r){
            swap(nums,l++,r--);
        }
    }

    public static void main(String[] args) {
        int []a = {1,5,1};
        new NextPermutation().nextPermutation(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
