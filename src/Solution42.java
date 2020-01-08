public class Solution42 {
    public int trap(int[] height) {
        //动态规划？
        //区间
        int res = 0,len=height.length,left=0,right=len-1;
        int left_max=0,right_max=0;
        if (len<2) return 0;
        while (left<right){
            if (height[left]<height[right]){
                if (height[left]>left_max){
                    left_max=height[left];
                }
                else {
                    res += (left_max-height[left]);
                }
                left+=1;
            }
            else {
                if (height[right]>right_max){
                    right_max=height[right];
                }
                else {
                    res += (right_max-height[right]);
                }
                right-=1;
            }
        }
        return res;

    }
    public int trap2(int[] height) {
        int res=0,len=height.length;
        if (len<2) return 0;
        int[] max_l = new int[len],max_r = new int[len];
        for (int i=1;i<len-1;i++){ // MAX_LEFT
            max_l[i]=Math.max(max_l[i-1],height[i-1]);
        }
        for (int i=len-2;i>0;i--){
            max_r[i]=Math.max(max_r[i+1],height[i+1]);
        }
        for (int i=1;i<len-1;i++){
            int tmp=Math.min(max_l[i],max_r[i])-height[i]>0?Math.min(max_l[i],max_r[i])-height[i]:0;
            res += tmp;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] b={5,2,1,2,1,5};
        for (int i = 0; i <a.length ; i++) {
            a[i] += 0;
        }
        int out = new Solution42().trap2(b);
        System.out.println(out);
    }
}
