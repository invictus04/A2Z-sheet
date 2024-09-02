class Solution {
    public boolean f(int ind, int[] arr, int[][] dp, int sum){
        if(sum == 0) return true;
        if(ind == 0) return (arr[0] == sum);
        if(dp[ind][sum] != -1) return dp[ind][sum] == 0 ? false: true;
        boolean notTake = f(ind-1,arr,dp,sum);
        boolean take = false;
        if(sum>=arr[ind]){
            take = f(ind-1,arr,dp,sum-arr[ind]);
        }
        dp[ind][sum] = take || notTake? 1:0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum=0;
        for(int i=0; i<n; i++){
            totalSum+=nums[i];
        }
        if(totalSum%2 == 1) return false;
        int sum = totalSum/2;

        int dp[][] = new int[n][sum+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,nums,dp,sum);


    }
}