import java.util.Collections;



public class Solution152 {
    public int maxProduct(int[] nums) {

        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        int res = Integer.MIN_VALUE;
/*
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            if (res < product) res = product;
            for (int j = i+1; j < nums.length; j++) {
                product *= nums[j];
                if (res < product) res = product;
            }
        }*/
        return dp(nums);
    }
    int dp(int[] nums) {
        int p_min=1,p_max = 1,max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
               int tmp = p_max;
               p_max = p_min;
               p_min = tmp;
            }
            p_max = Math.max(nums[i],p_max*nums[i]);
            p_min = Math.min(nums[i],p_min*nums[i]);
            max = Math.max(p_max,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {2,3,-2,4,-1};
        int[] b = {0,2};
        System.out.println(new Solution152().maxProduct(a));
    }
}
