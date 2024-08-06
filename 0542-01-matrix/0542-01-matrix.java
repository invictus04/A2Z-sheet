class Pair{
    int node;
    int prevnode;
    int dist;
    Pair(int node, int prevnode, int dist){
        this.node = node;
        this.prevnode = prevnode;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] vis = new int[n][m];
        int [][] distance = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int delrow [] = {-1,0,1,0};
        int delcol [] = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().node;
            int col = q.peek().prevnode;
            int dis = q.peek().dist;
            q.remove();
            distance[row][col] = dis;
            for(int i=0; i<4; i++){
                int nrow = row+ delrow[i];
                int ncol = col+ delcol[i];

                if(nrow >=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,dis+1));
                }
            }
        }
        return distance;
    }
}