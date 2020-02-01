import java.util.Arrays;

public class Solution75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 0) return;
        int p_zero = 0,p_two = len - 1;
        int curr = 0;
        while (curr <= p_two){
            if (nums[curr] == 0){
                swap(nums,curr,p_zero);
                p_zero += 1;
                curr += 1;
            }else if (nums[curr] == 2){
                swap(nums,curr,p_two);
                p_two -= 1;   /**这里不更改curr是因为当0的时候curr是从前p_zero换过来，
                              已经扫描过，p_two在curr后边没扫描过，所以swap之后还是要留在此位置*/
            }else curr += 1;

        }
    }
    private void swap(int[] nums,int a,int b){
        if (a == b) return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        new Solution75().sortColors(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t");
        }
    }
}
