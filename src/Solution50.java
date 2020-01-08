public class Solution50 {
    public double myPow(double x, int n) {
        // 二分法
        if (n==0||x==1) return 1.0;
        else if (n>0) return jiSuan(x,n);
        else {
            if (n==Integer.MIN_VALUE){
                return 1/jiSuan(x*x,Integer.MAX_VALUE);
            }
            else return 1/jiSuan(x,-n);

        }

    }
    double jiSuan(double x,long n){
        if (n==1) return x;
        if (n%2==0) {
            double tmp = jiSuan(x, n/2);
            return tmp*tmp;
        }
        else {
            double tmp = jiSuan(x, n/2);
            return x*tmp*tmp;

        }
    }

    public static void main(String[] args) {
        double out = new Solution50().myPow(-1,-2147483648);
        System.out.println(out);
    }
}
