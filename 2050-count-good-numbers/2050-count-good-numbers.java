class Solution {
    static int M =(int)1000000007;
     public long myPow(long x, long n) {
     if(n==0) return 1;
     long ans = myPow(x,n/2);
        if(n%2 == 0) {
            return((ans%M)*(ans%M))%M;
        }else{
            return(x*(ans%M)*(ans%M))%M;
        }
     }
    public int countGoodNumbers(long n) {
        if(n == 0) return 0;
        if(n == 1) return 5;
        
        long evenplaces = myPow(5,(n+1)/2)%M;
        long oddplaces = myPow(4,n/2)%M;
        return(int)((evenplaces*oddplaces)%M);
    }
}