package sortTest;

import java.util.Arrays;

public class mergeSort {
    void sort(int[] nums,int start,int end,int[] cache){
        if (start==end) return;
        int mid = start + (end-start)/2;
        sort(nums, start, mid,cache);
        sort(nums,mid+1,end,cache);
        merge(nums,start,mid,end,cache);
    }

    private void merge(int[] nums, int start, int mid, int end,int[] cache) {
        int[] tmp = new int[end-start+1];
        int p1 = start,p2 = mid+1,pos = start;
        while (p1<=mid&&p2<=end){
            if (nums[p1]<nums[p2]){
                cache[pos] = nums[p1];
                p1++;
            }else {
                cache[pos] = nums[p2];
                p2++;
            }
            pos++;
        }
        while (p1<=mid) cache[pos++] = nums[p1++];
        while (p2<=end) cache[pos++] = nums[p2++];
        for (int i = start; i <=end ; i++) {
            nums[i] = cache[i];
        }
    }

    public static void main(String[] args) {
        int[] in = {9,-1,20,-5,-6,7,8,9,1,100,20};
        int[] cache = new int[in.length];
        new mergeSort().sort(in,0,in.length-1,cache);
        System.out.println(Arrays.toString(in));
    }
}
