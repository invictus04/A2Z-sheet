class Solution {
    public double myPow(double x, int n) {
        // double ans = 1.0;
        // long N = n;
        // if(N<0) N=-N;
        // while(N>0) {
        //     if(N%2 == 0){
        //         x= x*x;
        //         N=N/2;
        //     } else {
        //         ans = ans*x;
        //         N=N-1;
        //     }
        // }

        // if(n<0) ans=(double)(1.0)/(double)(ans);
        // return ans;

        if(n ==0) return 1.0;
        long N = n;
        if(N<0){
            N = -N;
            x= 1/x;
        }

        if(N%2 == 0) {
            return myPow(x*x,(int)(N/2));
        } else {
            return x * myPow(x,(int)(N-1));
        }

    }
}