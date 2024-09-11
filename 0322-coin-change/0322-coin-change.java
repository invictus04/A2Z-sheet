class Solution {
    public int helper(int ind, int amount, int[] coins, int[][] dp){
        if(amount == 0) return 0;
        if(ind == 0){
            if(amount%coins[ind] == 0){
                return amount/coins[ind];
            } else {
                return (int) 1e9;
            }
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];

        int notTake = helper(ind-1,amount,coins,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=amount){
            take = 1 + helper(ind, amount - coins[ind], coins, dp);
        }
        return dp[ind][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int ele[]: dp){
            Arrays.fill(ele,-1);
        }
        int res = helper(n-1,amount,coins,dp);
        return res>= (int) 1e9?-1: res;
    }
} 