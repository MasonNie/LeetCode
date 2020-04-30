package sortTest;

import java.util.Stack;

public class quickSort {
    void sort(int[] nums,int start,int end){
        if(start>end) return;
        int idx = partition(nums,start,end);
        if(idx>start) sort(nums, start, idx-1);
        if (idx<end) sort(nums, idx+1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int flag = nums[start],l = start,r = end;
        while (l<r){
            while (l<r&&nums[r]>=flag){ //先走右边是因为下边用的是l，考虑已经有序的情况，先走左边会出错
                r--;
            }
            while (l<r&&nums[l]<=flag){
                l++;
            }
            if (l<r) {
                swap(nums,l,r);
            }

        }
        swap(nums, start, l);
        return l;

    }

    private void swap(int[] nums, int a, int b) {
        if(a==b) return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] in = {9,-1,20,-5,-6,7,8,9,1,100,20};
        new quickSort().sort(in,0,in.length-1);
        for (int i = 0; i < in.length; i++) {
            System.out.print(in[i]+" ");
        }
        String a = "a";
        a = a.substring(1);
        System.out.println(a);
        Stack<Integer> s= new Stack<>();
        s.clear();
    }
}
