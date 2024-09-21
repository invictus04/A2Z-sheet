class Solution {
    private int helper(int[] nums, int n, int ind, int prev, int dp[][]) {
        if (ind == n)
            return 0;
        if (dp[ind][prev + 1] != -1)
            return dp[ind][prev + 1];
        int notTake = helper(nums, n, ind + 1, prev, dp);
        int take = 0;
        if (prev == -1 || nums[prev] < nums[ind]) {
            take = 1 + helper(nums, n, ind + 1, ind, dp);
        }
        return dp[ind][prev + 1] = Math.max(notTake, take);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        // for(int row[]: dp){
        // Arrays.fill(row,-1);
        // }
        // return helper(nums,n,0,-1,dp);

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int notTake = dp[ind + 1][prev + 1];
                int take = Integer.MIN_VALUE;
                if (prev == -1 || nums[prev] < nums[ind]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }
}