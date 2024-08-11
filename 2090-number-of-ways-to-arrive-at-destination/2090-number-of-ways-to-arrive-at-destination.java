class Pair {
    long first; // This will store the distance.
    int second; // This will store the node index.

    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2], roads[i][0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.first, y.first));
        long[] dis = new long[n];
        int[] ways = new int[n];

        for (int i = 0; i < n; i++) {
            dis[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        pq.add(new Pair(0, 0));
        dis[0] = 0;
        ways[0] = 1;

        int mod = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long dist = current.first;
            int node = current.second;

            for (Pair it : adj.get(node)) {
                int adjNode = it.second;
                long wt = it.first;

                if (dist + wt < dis[adjNode]) {
                    dis[adjNode] = dist + wt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                    ways[adjNode] = ways[node];
                } else if (dist + wt == dis[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
