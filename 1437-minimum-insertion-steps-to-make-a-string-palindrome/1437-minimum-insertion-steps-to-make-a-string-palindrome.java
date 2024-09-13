class Solution {
    private int sub(int ind1,int ind2,String text1, String text2, int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)) return dp[ind1][ind2] = 1 + sub(ind1-1, ind2-1,text1,text2,dp);
        return dp[ind1][ind2] = Math.max(sub(ind1-1,ind2,text1,text2,dp), sub(ind1,ind2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }

        return sub(n-1,m-1,text1,text2,dp);
    }
    public int longestPalindromeSubseq(String s) {
        StringBuffer rev = new StringBuffer(s);
        return longestCommonSubsequence(s,rev.reverse().toString());
    }
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
}