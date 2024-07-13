class Solution {
    public int maxScore(int[] cardpoints, int k) {
        int n = cardpoints.length;
        // int max = Integer.MIN_VALUE;
        int lsum=0,rsum=0;
        int r = n-1;

        for(int i=0; i<k; i++) {
            lsum+=cardpoints[i];
        }
        int max=lsum;

        for(int i=k-1; i>=0; i--){
            lsum-=cardpoints[i];
            rsum+=cardpoints[r];
            r--;
            // sum = lsum+rsum;
            max = Math.max(max,lsum+rsum);
        }
        return max;
    }
}