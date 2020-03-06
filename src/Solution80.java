public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int len = 0,count = 1,pos = 0; //pos代表当前去重后正确数组最后一个位置
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[pos]){
                count++;
                if (count > 2){
                    nums[pos] = nums[i]; //重复了代表这个数字多余，pos不必要向前
                }
                else {
                    pos++;
                    nums[pos] = nums[i];
                }
            }
            else {
                count = 1;
                pos++;
                nums[pos] = nums[i];
            }


        }
        return pos + 1;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,1,2,3,3,3};
        int[] b = {};
        int[] in = b;
        int len = new Solution80().removeDuplicates(in);
        for (int i = 0; i < len; i++) {
            System.out.print(in[i] + " ");
        }
    }
}
