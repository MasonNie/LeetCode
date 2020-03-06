package com.part;

public class SearchInRotatedSortedArray {
    private int erFen(int []nums,int l,int r,int target){
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid]<target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int cut,res,len=nums.length;
        if (len == 0) return -1;
        int l=0,r=len-1;
        //找分段点
        while (l<r){
            int mid = (l+r)/2;
            if (mid>0&&nums[mid]<nums[mid-1]) {
                l = mid;
                break;
            }
            else if (nums[mid]<nums[0]+mid) r = mid-1;
            else l = mid+1;
        }
        res = erFen(nums,0,l-1,target);
        if (res>-1) return res;
        res = erFen(nums,l,len-1,target);
        return res;
        //两段二分查找

    }

    public static void main(String[] args) {
        int a[] = {4,5,6,7,0,1,2};
        int out = new SearchInRotatedSortedArray().search(a,3);
        System.out.println(out);
    }

}
