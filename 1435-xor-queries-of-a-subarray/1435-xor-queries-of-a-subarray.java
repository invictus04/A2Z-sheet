class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length];
        // if(arr.length == 1) return ans;
        int ind=0;
        for(int i=0; i<queries.length; i++){
            int min = queries[i][0];
            int max = queries[i][1];
            int xor = 0;
            for(int j=min; j<=max; j++){
                xor = xor^arr[j];
            }
            ans[ind++] = xor;
        }
        return ans;
    }
}