class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges[0].length;
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dist[i][j] = (int)1e9;
                dist[i][i]=0;
            }   
        }
        for(int[] it: edges){
            int u = it[0];
            int v = it[1];
            int w = it[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for(int via=0; via<n; via++){
            for(int i=0; i<n; i++){
                for(int j=0;j<n;j++){
                    // if(dist[i][via] == 1e7 || dist[via][j] == 1e7) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][via]+ dist[via][j]);
                }
            }
        }

        int countMax=n;
        int cntCity=-1;
        for(int city=0; city<n; city++){
            int cnt=0;
            for(int adjCity =0; adjCity<n; adjCity++){
                if(city == adjCity) continue;
                if(dist[city][adjCity]<=distanceThreshold) cnt++;
            }

            if(cnt<=countMax){
                countMax=cnt;
                cntCity = city;
            }
        }

        return cntCity;
    }
}