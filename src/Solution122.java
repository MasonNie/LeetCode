import java.util.Arrays;
import java.util.Collections;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0,min_prices = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min_prices) min_prices = prices[i];
            else {
                res += prices[i] - min_prices;
                min_prices = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int[] b = {7,6,4,3,1};
        int[] c = {1,2,3,4};
        System.out.println(new Solution122().maxProfit(c));
    }
}
