class Solution {
    private boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private int helper(int i, int n, String s, int dp[]){
        if(i==n) return 0;
        if(dp[i] != -1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            if(isPalindrome(i,j,s)){
                int cost = 1 + helper(j+1,n,s,dp);
                minCost = Math.min(minCost,cost);
            }
        }
        return dp[i] = minCost;
    }
    public int minCut(String s) {
       int n = s.length();
       int dp[] = new int[n];
       Arrays.fill(dp,-1);
       return helper(0,n,s,dp)-1;

    }
}