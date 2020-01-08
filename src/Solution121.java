public class Solution121 {
    public int maxProfit(int[] prices) {
//        int m = prices.length,res = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                if (i<=j){
//                   res  = Math.max(res,prices[j] - prices[i]);
//                }
//            }
//        }
        return bigOn(prices);
    }
    int bigOn(int[] prices){
        int res = 0,min_prices = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min_prices)
                min_prices = prices[i];
            else {
                res = Math.max(res,prices[i]-min_prices);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int[] b = {7,6,4,3,1};
        System.out.println(new Solution121().maxProfit(a));
    }
}
