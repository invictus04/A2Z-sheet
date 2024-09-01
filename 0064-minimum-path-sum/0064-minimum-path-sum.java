class Solution {
    private int minPath(int[][] grid,int[][] dp, int i, int j){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i>0){
        up = grid[i][j] + minPath(grid,dp,i-1,j);
        }
        if(j>0){
        left= grid[i][j] + minPath(grid,dp,i,j-1);
        }
        return dp[i][j] = Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return minPath(grid,dp,n-1,m-1);
    }
}