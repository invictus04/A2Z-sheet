class Solution {
    int[] parent;
    int[] rank;

    public int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu != pv) {
            int ru = rank[pu];
            int rv = rank[pv];
            if (ru > rv) {
                parent[pv] = pu;
            } else if (rv > ru) {
                parent[pu] = pv;
            } else {
                parent[pu] = pv;
                rank[pv]++;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int maxrow = 0;
        int maxcol = 0;
        int n = stones.length;

        for (int i = 0; i < n; i++) {
            maxrow = Math.max(maxrow, stones[i][0]);
            maxcol = Math.max(maxcol, stones[i][1]);
        }

        
        parent = new int[maxrow + maxcol + 2];
        rank = new int[maxrow + maxcol + 2];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i; 
        }

        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int noderow = stones[i][0];
            int nodecol = stones[i][1] + maxrow + 1;
            union(noderow, nodecol);
            mpp.put(noderow, 1);
            mpp.put(nodecol, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (findParent(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }
}
