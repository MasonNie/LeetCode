public class Solution53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;


    }
    int maxSubArray2(int[] nums){
        int res=Integer.MIN_VALUE,len=nums.length;
        if (len==0) return 0;
        for (int i = 0; i < len; i++) {//求和
            int total=0;
            for (int j = i; j < len; j++) {
                total +=nums[j];
                res= Math.max(res,total);

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        a = new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        int out = new Solution53().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(out);
    }
}
