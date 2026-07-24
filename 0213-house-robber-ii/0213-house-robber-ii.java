class Solution {

    public int helper(int [] nums, int start, int end, int sum, int[] dp){
        if(start == end) return nums[start];
        if(start < end) return 0;
        if(dp[start] != -1) return dp[start];
        int pick = nums[start] + helper(nums, start-2, end, sum,dp);
        int notPick = helper(nums, start-1,end, sum,dp);
        return dp[start] = Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        //n-2 -> 0
        //n-1 -> 1
        if(nums.length == 1) return nums[0];
        int dp1[] = new int[nums.length+1];
        int dp2[] = new int[nums.length+1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int left = helper(nums, nums.length-2,0, 0, dp1);
        int right = helper(nums, nums.length-1,1, 0,dp2);
        System.out.print(left + " " + right);
        return Math.max(left,right);
    }
}