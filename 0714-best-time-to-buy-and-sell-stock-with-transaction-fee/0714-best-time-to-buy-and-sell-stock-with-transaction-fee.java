class Solution {
    private int helper(int ind, int buy, int prices[], int n, int fee, int[][] dp){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit =0;
        if(buy == 1){
            profit = Math.max(-prices[ind] - fee + helper(ind+1,0,prices,n,fee,dp), helper(ind+1, 1,prices,n,fee,dp));
        } else {
            profit = Math.max(prices[ind]+helper(ind+1,1,prices,n,fee,dp), helper(ind+1,0,prices,n,fee,dp));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        // dp[n][0] = dp[n][1] = 0;
        for(int i = n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                int profit =0;
                if(j == 1){
                    profit = Math.max(-prices[i] - fee + dp[i+1][0], dp[i+1][1]);
                } else {
                    profit = Math.max(prices[i]+dp[i+1][1], dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
    
}