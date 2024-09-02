class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }
        for (int j = 0; j < m; j++) {
            int temp = memo(matrix, dp, n - 1, j, n, m);
            max = Math.min(max, temp);
        }
        return max;
    }

    public int memo(int[][] ar, int[][] dp, int i, int j, int n, int m) {
        if (j < 0 || j >= m)
            return (int) 1e9;
        if (i == 0 && (j >= 0 && j < m))
            return ar[0][j];
        if (dp[i][j] != (int) 1e9)
            return dp[i][j];
        int right = memo(ar, dp, i - 1, j - 1, n, m) + ar[i][j];
        int down = memo(ar, dp, i - 1, j, n, m) + ar[i][j];
        int left = memo(ar, dp, i - 1, j + 1, n, m) + ar[i][j];
        return dp[i][j] = Math.min(right, Math.min(down, left));

    }
}