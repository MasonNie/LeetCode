public class Solution45 {
    public int jump(int[] nums) {
        int len=nums.length;
        int[] step=new int[len];
        step[0]=0;
        for (int i = 1; i < len; i++) {
            step[i]=Integer.MAX_VALUE;
        }
        for (int i=0;i<len;i++){
            for (int j = i+1; j < i+nums[i]+1; j++) {
                if (j<len) step[j]=Math.min(step[i]+1,step[j]);
                else break;
            }

        }
        return step[len-1];
    }

    public static void main(String[] args) {
        int[] a = {4,3,1,1,4,1,6};
        int out = new Solution45().jump(a);
        System.out.println(out);
    }
}
