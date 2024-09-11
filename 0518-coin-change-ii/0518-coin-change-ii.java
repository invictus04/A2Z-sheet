class Solution {
    private int helper(int ind, int amount, int coins[], int dp[][]){
        if(amount == 0) return 1;
        if(ind == 0){
            return (amount%coins[ind] == 0) ? 1:0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = helper(ind-1, amount, coins, dp);
        int take = 0;
        if(amount>=coins[ind]){
            take = helper(ind,amount-coins[ind], coins,dp);
        }
        return dp[ind][amount] = take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return helper(n-1,amount,coins,dp);
    }
}