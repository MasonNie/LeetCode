package sortTest;

import java.util.Arrays;

public class heapSort {
    void sort(int[] nums){
        int len = nums.length;
        for (int i = (len-1-1)/2; i >= 0; i--) {
            heapify(nums,i,len-1);
        }
        int end = len-1;
        while(end>0){
            int tmp = nums[end];
            nums[end] = nums[0];
            nums[0] = tmp;
            end--;
            heapify(nums,0,end);
        }
    }

    private void heapify(int[] nums, int idx,int end) {
        int val = nums[idx],left = 2*idx+1;
        while(left<=end){
            int bigest = left;
            if(left+1<=end){
                if(nums[left+1]>nums[left]){
                    bigest = left+1;
                }
            }
            if (nums[bigest]<=val) break;
            nums[idx] = nums[bigest];
            idx = bigest;
            left = 2*idx + 1;

        }
        nums[idx] = val;
    }
    void heapSort2(int[] nums){
        for(int i=(nums.length-1-1)/2;i>=0;i--){
            heapify2(nums,i,nums.length-1);
        }
        for(int i=nums.length-1;i>0;i--){
            //swap
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify2(nums,0,i-1);
        }
    }
    void heapify2(int[] nums,int idx,int end){
        int left = 2*idx+1,val = nums[idx];
        while(left<=end){
            int big = left;
            if(left+1<=end&&nums[left]<nums[left+1]){
                big = left+1;
            }
            if(nums[big]<=val) break;
            nums[idx] = nums[big];
            idx = big;
            left = 2*idx + 1;
        }
        nums[idx] = val;
    }

    public static void main(String[] args) {
        int[] in = {9,-1,20,-5,-6,7,8,9,1,100,20};
        int[] cache = new int[in.length];
        new heapSort().heapSort2(in);
        System.out.println(Arrays.toString(in));
    }
}
