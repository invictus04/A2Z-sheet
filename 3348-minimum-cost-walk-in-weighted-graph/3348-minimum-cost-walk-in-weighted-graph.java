class Solution {
    int[] parent;
    int[] depth;

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        Arrays.fill(parent, -1);

        depth = new int[n];
        int[] componentCost = new int[n];
        Arrays.fill(componentCost, Integer.MAX_VALUE);

        for(int[] edge: edges){
            union(edge[0], edge[1]);
        }

        for(int[] edge: edges){
            int root = find(edge[0]);
            componentCost[root] &= edge[2];
        }
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            int start = query[i][0];
            int end = query[i][1];

            if(find(start) != find(end)){
                answer[i] = -1;
            } else {
                int root = find(start);
                answer[i] = componentCost[root];
            }
        }
        return answer;
        
    }


    private int find(int node){
        if(parent[node] == -1) return node;
        return parent[node] = find(parent[node]);
    }

    private void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 == root2) return;

        if(depth[root1] < depth[root2]){
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        parent[root2] = root1;

        if(depth[root1] == depth[root2]) {
            depth[root1] ++;
        }
    }
}