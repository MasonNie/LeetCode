import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Solution137 {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return -1;
        int[] bits = new int[32];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int bitMask = 1;
            for(int j=31;j>=0;j--){
                int bit = bitMask&nums[i];
                if(bit!=0) bits[j]+=1;
                bitMask = bitMask<<1;
            }
        }
        int res = 0;
        for(int i=0;i<32;i++){
            res = res<<1;
            res += bits[i]%3;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,2,3,2};

        System.out.println(new Solution137().singleNumber(a));
    }
}
