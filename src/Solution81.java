public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums[0] == target) return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                return erFen(nums,i,nums.length-1,target);
            }
            else if (nums[i] == target)
                return true;

        }
        return false;
    }
    private boolean erFen(int[] nums,int l,int r,int target){
        while (l <= r){
            int mid = (l + r) >> 1;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,5,6,0,0,1,2};
        int[] in = a;
        int target = 3;
        System.out.println(new Solution81().search(in,target));
    }
}
