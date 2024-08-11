class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

}
class Tuple{
    int stops;
    int node;
    int distance;
    Tuple(int stops, int node, int distance){
        this.distance = distance;
        this.node = node;
        this.stops = stops;
    }

}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;

        for(int i=0; i<m; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int dist[] = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)(1e9);
        }

        dist[src] = 0;

        while(!q.isEmpty()){
            Tuple it = q.peek();
            int stops = it.stops;
            int dis=it.distance;
            int node = it.node;
            q.remove();

            if(stops>k) continue;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int edw = iter.second;
                if(dis+edw<dist[adjNode] && stops <=k){
                    dist[adjNode] = dis+edw;
                    q.add(new Tuple(stops+1,adjNode,dis+edw));

                }
            }
        }

        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];

    }
}