class Solution {
    public boolean dfs(int[][] graph, int node, int col, int color[]){
        color[node] = col;
        for(int it: graph[node]){
                if(color[it] == -1){
                    if(dfs(graph,it,1-col,color)==false) return false;
                } else if(color[it] == col){
                    return false;
                }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0; i<n;i++){
            color[i] = -1;
        }
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(dfs(graph,i,0,color)==false) return false;
            }
        }
        return true;
    }
}