class Solution {
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj, int [] vis) {
        vis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it,adj,vis);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
       ArrayList<ArrayList<Integer>> adjs  = new ArrayList<>();
       int V = isConnected.length;
       for(int i=0; i<V; i++) {
        adjs.add(new ArrayList<>());
       }

       for(int i=0; i<V; i++){
        for(int j=0; j<V;j++){
            if(isConnected[i][j] == 1 && i!=j){
                adjs.get(i).add(j);
                adjs.get(j).add(i);
            }
        }
       }
       int vis[] = new int[V+1];
       int cnt=0;
       for(int i=0; i<V; i++){
        if(vis[i] == 0){
            cnt++;
            dfs(i,adjs,vis);
        }
       }
       return cnt;
    }
}