class Solution {
    private int helper(int i, int j, List<Integer> cut, int[][] dp){
        if(i>j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind=i; ind<=j; ind++){
            int costs = cut.get(j+1)-cut.get(i-1) + helper(i,ind-1,cut,dp) + helper(ind+1,j,cut,dp);
            mini = Math.min(mini,costs);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        List<Integer> cut = new ArrayList<>();
        for(int c: cuts){
            cut.add(c);
        }
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        int [][] dp = new int[len+2][len+2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }

        return helper(1,len,cut,dp);
    }
}