class Solution {
    private int helper(int ind, int buy, int prices[], int n, int dp[][]){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit =0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + helper(ind+1,0,prices,n,dp), helper(ind+1, 1,prices,n,dp));
        } else {
            profit = Math.max(prices[ind]+helper(ind+1,1,prices,n,dp), helper(ind+1,0,prices,n,dp));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return helper(0,1,prices,n,dp);
    }
}