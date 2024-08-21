class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int dp[][] = new int[n][n];
        for(int[] it: dp){
            Arrays.fill(it,-1);
        }
        return Util(0,n-1,ch,dp);
    }

    public int Util(int i, int j, char[] ch, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int first = ch[i];
        int ans = 1 + Util(i+1, j ,ch, dp);

        for(int k = i+1; k<=j; k++){
            if(ch[k] == first){
            int betterans = Util(i,k-1,ch,dp) + Util(k+1,j,ch,dp);
            ans = Math.min(ans,betterans);   
            }
        }
        return dp[i][j] = ans;
    }
}