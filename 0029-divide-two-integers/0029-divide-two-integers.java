class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
          if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow case
        }
        boolean sign = true;
        if(dividend >=0 && divisor<0) sign = false;
        else if(dividend <=0 && divisor>0) sign = false;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while(n>=d) {
            int cnt =0;
            while(n>=(d <<(cnt+1))){
                cnt++;
            }
            quotient += 1<<cnt;
            n-=(d<<cnt);
        }
        if(quotient == (1<<31) && sign) {return Integer.MAX_VALUE;}
        if(quotient == (1<<31) && !sign) {return Integer.MIN_VALUE;}

        return sign ? quotient : -quotient;
    }
}