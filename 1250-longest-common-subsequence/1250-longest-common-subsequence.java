class Solution {

    public int helper(int ind1, int ind2, String text1, String text2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0)
            return 0;
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
            return 1 + helper(ind1 - 1, ind2 - 1, text1, text2, dp);
        }
        return dp[ind1][ind2] = Math.max(helper(ind1, ind2 - 1, text1, text2, dp),
                helper(ind1 - 1, ind2, text1, text2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int i=0; i<=text1.length(); i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=text2.length(); j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=text1.length(); i++){
            for(int j=1; j<=text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}