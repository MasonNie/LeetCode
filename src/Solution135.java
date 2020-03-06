import java.util.HashMap;

public class Solution135 {
    public int candy(int[] ratings) {
        int res = 1,len = ratings.length,up = 0,down = 0,top = 0;
        for(int i=1;i<len;i++){
            if (ratings[i]>ratings[i-1]){
                up++;
                top = up;
                down = 0;
                res += (1+up);
            }else if (ratings[i]==ratings[i-1]){
                up = top = down =0;
                res += 1;
            }else {
                up = 0;
                down++;
                res += 1 + down + (top>=down?-1:0);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {1,2,5};
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println(new Solution135().candy(a));
    }
}
