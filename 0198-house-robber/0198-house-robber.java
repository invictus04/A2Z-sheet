class Solution {
    private int help(int[] nums, int[] dp, int ind){
        if(ind == 0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = help(nums,dp,ind-2)+nums[ind];
        int notPick = 0+help(nums,dp,ind-1);
        return dp[ind] = Math.max(pick,notPick);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return help(nums,dp,n-1);
    }
}