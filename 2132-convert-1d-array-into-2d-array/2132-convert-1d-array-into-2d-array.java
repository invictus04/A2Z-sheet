class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        int ind = 0;
        if(m*n != len){
            return new int[][]{};
        }
        int [][] ans = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(ind<=len-1){
                    ans[i][j] = original[ind++];
                }
            }
        }
        return ans;
    }
}