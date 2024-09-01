class Solution {
    private int findPath(int m, int n, int[][] dp){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;

        if(dp[m][n] != -1) return dp[m][n];
        int up = findPath(m-1,n,dp);
        int left = findPath(m,n-1,dp);

        return dp[m][n] = up+left;
    }
    
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return findPath(m-1,n-1,dp);
    }
}