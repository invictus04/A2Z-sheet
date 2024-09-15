class Solution {
    private int helper(int ind, int buy, int prices[], int n){
        if(ind >= n) return 0;
        int profit =0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + helper(ind+1,0,prices,n), helper(ind+1, 1,prices,n));
        } else {
            profit = Math.max(prices[ind]+helper(ind+2,1,prices,n), helper(ind+1,0,prices,n));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        //  dp[n][0] = dp[n][1] = 0;
        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                int profit =0;
                if(j == 1){
                    profit = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    profit = Math.max(prices[i]+dp[i+2][1], dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
        // return helper(0,1,prices,n);
    }
}