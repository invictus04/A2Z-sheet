class Solution {
    private int helper(int i, int j, List<Integer> list, int dp[][]){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind = i; ind<=j; ind++){
            int burst = list.get(i-1)*list.get(ind)*list.get(j+1)+helper(i,ind-1,list,dp)+helper(ind+1,j,list,dp);
            maxi = Math.max(maxi,burst);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int ele: nums){
            list.add(ele);
        }
        list.add(1);
        int dp[][] = new int[n+2][n+2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return helper(1,n,list,dp);
    }
}