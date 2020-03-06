package com.part;

public class FindFirstAndLastPositionOfElementInSortedArray {
    int erFen(int[] nums,int l,int r,int target){
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid]==target){
                return mid;
            }
            else if (nums[mid]<target) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int len = nums.length;
        if (len == 0 ) return res;
        int cut = erFen(nums,0,len-1,target);
        if (cut == -1) return res;
        //左边
        int l=0,r=cut-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid+1]==target&&nums[mid]<target){
                res[0] = mid+1;
                break;
            }
            else if (nums[mid]<target) l = mid+1;
            else r = mid-1;
        }
        //右边
        l = cut+1;r = len-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid-1]==target&&nums[mid]>target){
                res[1] = mid-1;
                break;
            }
            else if (nums[mid]>target) r = mid-1;
            else l = mid+1;
        }
        if (nums[0]==target) res[0]=0;
        if (nums[len-1]==target) res[1]=len-1;
        return res;
    }

    public static void main(String[] args) {
        int[] a = {7,7,7,8,8,9,10,10};
        int[] out = new  FindFirstAndLastPositionOfElementInSortedArray().searchRange(a,9);
        System.out.println(out[0]+"  "+out[1]);
    }
}
