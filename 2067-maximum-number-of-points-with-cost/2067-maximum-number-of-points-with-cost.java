class Solution {
    public long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long[] prevRow = new long[col];

        for(int i=0; i<col; ++i){
            prevRow[i] = points[0][i];
        }

        for(int i=1; i<row; i++){
            long[] left = new long[col];
            long[] right = new long[col];
            long[] curr = new long[col];

            left[0] = prevRow[0];

            for(int j=1; j<col; j++){
                left[j] = Math.max(left[j-1]-1,prevRow[j]);
            }

            right[col-1] = prevRow[col-1];
            for(int j= col-2; j >=0; j--){
                right[j] = Math.max(right[j+1]-1,prevRow[j]);
            }

            for(int j=0; j<col; j++){
                curr[j] = points[i][j] + Math.max(left[j],right[j]);
            }
            prevRow = curr;
        }

        long maxPoints =0;
        for(int i=0; i<col; i++){
            maxPoints = Math.max(maxPoints,prevRow[i]);
        }

        return maxPoints;
    }
}