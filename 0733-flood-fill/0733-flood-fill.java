class Solution {
    public void dfs(int[][] image,int[][] vis, int row, int col, int color, int inicolor, int delrow[], int delcol[]){
        vis[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == inicolor && vis[nrow][ncol] != color){
                dfs(image,vis,nrow,ncol,color,inicolor,delrow,delcol);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int ans[][] = image;
    int inicolor = image[sr][sc];
    int delrow[] = {-1,0,1,0};
    int delcol []= {0,1,0,-1};
    dfs(image,ans,sr,sc,color, inicolor,delrow,delcol);
    return ans;

    }
}