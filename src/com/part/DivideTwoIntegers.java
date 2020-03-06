package com.part;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int res = 0;
        if (dividend==0) return res;
        if (dividend==Integer.MIN_VALUE){
            if (divisor==1) return Integer.MIN_VALUE;
            else if (divisor==-1) return Integer.MAX_VALUE;
        }
        int flag = 1;
        if (dividend>0&&divisor<0 || dividend<0&&divisor>0)
            flag = -1;
        dividend = dividend<0?dividend:-dividend;
        divisor = divisor<0?divisor:-divisor;
        while (dividend<=divisor){
            dividend = dividend - divisor;
            res ++;
        }
        return res*flag;
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int out = solution.divide(Integer.MIN_VALUE,2);
        System.out.println(out);
    }
}
