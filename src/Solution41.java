public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        //先处理不是正数的元素

        int res=0,len = nums.length,small = Integer.MAX_VALUE;
        for (int i=0;i<len;i++){
            if (nums[i]>0&&nums[i]<small) small=nums[i];
            else nums[i] = 0;
        }
        if (small>1) return 1;

        //将出现的元素的位置标记为负数
        for (int i = 0; i < len; i++) {
            int pos = Math.abs(nums[i]);
            if (pos>0&&pos<len){
                if (nums[pos]>0) nums[pos] *= -1;
            }
//            if (nums[i]>0&&nums[i]<len&&nums[nums[i]]>0) nums[nums[i]] = -nums[nums[i]];
        }
        for (int i = 1; i < len; i++) {
            if (nums[i]>=0) return i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {1,2,0};
        int out = new Solution41().firstMissingPositive(in);
        System.out.println(out);
    }
}
