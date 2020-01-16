public class Solution55 {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        if (size<2) return true;
        if (size<3) return nums[0]>0;
        for (int i = 1; i < size-1; i++) {
            if (nums[i-1]<i) return false;
            else nums[i] = Math.max(i+nums[i],nums[i-1]);
            if (nums[i] >= size-1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        int[] b = {3,2,1,0,4,5,6};
        System.out.println(new Solution55().canJump(b));
    }
}
