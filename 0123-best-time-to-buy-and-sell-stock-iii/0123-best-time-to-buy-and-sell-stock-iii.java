class Solution {
    private int helper(int ind, int buy, int cap, int n, int[] prices, int[][][] dp){
        if(ind == n) return 0;
        if(cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[ind] + helper(ind+1,0,cap,n,prices,dp), helper(ind+1,1,cap,n,prices,dp));
        } else {
            profit = Math.max(prices[ind]+helper(ind+1,1,cap-1,n,prices,dp),helper(ind+1,0,cap,n,prices,dp));
        }
        return dp[ind][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,1,2,n,prices,dp);
    }
}