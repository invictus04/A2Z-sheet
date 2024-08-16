class Tuple{
    int distance;
    int row;
    int col;
    Tuple(int distance, int row, int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.distance-y.distance);

        int dis[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dis[i][j] = (int)(1e9);
            }
        }

        dis[0][0]=0;
        pq.add(new Tuple(grid[0][0],0,0));
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        while(!pq.isEmpty()){
            Tuple it = pq.peek();
            pq.remove();
            int dist = it.distance;
            int row = it.row;
            int col = it.col;

            if(row==n-1 && col == m-1) return dist;

            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int maxEffect = Math.max(grid[nrow][ncol], dist);
                    if(maxEffect<dis[nrow][ncol]){
                        dis[nrow][ncol] = maxEffect;
                        pq.add(new Tuple(maxEffect,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}