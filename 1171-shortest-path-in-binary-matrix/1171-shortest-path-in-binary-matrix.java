class Tuple {
    int row;
    int col;
    int dist;
    
    Tuple(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if(n == 1) return 1;

        Queue<Tuple> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        int[] delRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delCol = {-1, 0, 1, 1, 1, 0, -1, -1};

        q.add(new Tuple(0, 0, 1));
        vis[0][0] = true;

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int dist = curr.dist;

            for (int i = 0; i < 8; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !vis[newRow][newCol] && grid[newRow][newCol] == 0) {
                    
                    if (newRow == n-1 && newCol == n-1) return dist + 1;

                    q.add(new Tuple(newRow, newCol, dist + 1));
                    vis[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}
