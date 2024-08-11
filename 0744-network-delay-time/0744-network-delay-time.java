import java.util.*;

class Pair {
    int node;
    int distance;
    
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : times) {
            int u = edge[0] - 1; 
            int v = edge[1] - 1; 
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }
        
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0; 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));
        pq.add(new Pair(k - 1, 0));
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int d = current.distance;
            
            if (d > dist[node]) {
                continue;
            }
            
            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.distance;
                
                if (d + weight < dist[nextNode]) {
                    dist[nextNode] = d + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        
        
        int maxDist = 0;
        for (int distance : dist) {
            if (distance == Integer.MAX_VALUE) {
                return -1; 
            }
            maxDist = Math.max(maxDist, distance);
        }
        
        return maxDist;
    }
}
