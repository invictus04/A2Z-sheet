class Solution {
    private int obstacles(int[][] dp,int[][] obstacleGrid, int n, int m){
        if(n>=0 && m>=0 && obstacleGrid[n][m] == 1) return 0;
        if(n == 0 && m==0) return 1;
        if(n<0 || m<0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        int up = obstacles(dp,obstacleGrid,n-1,m);
        int left = obstacles(dp,obstacleGrid,n,m-1);
        return dp[n][m] = left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }

        return obstacles(dp,obstacleGrid,n-1,m-1);
    }
}