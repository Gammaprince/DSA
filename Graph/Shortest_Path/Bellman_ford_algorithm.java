Bellman ford also works for -ve weight unlike dijastra's but with N^2 Time complexity
  **Relax all the edges N-1 Times sequentially
  **Relaxation is if(dist[u] + weight < dist[v]){
                      dist[v] = dist[u] + weight
                   }
    Do this relaxation for all edges N-1 times from src
    Create an infinite marked 1D Array , make source = 0 , then start relaxing all the edges N-1 times

 Why we must run N-1 times for all edges?
  Since in a graph of N nodes, in worst case , you will take N-1 edges to reach from the first to the last, 
  thereby we iterate for N-1 iterations.

  Try drawing a graph which takes more than N-1 edges for any path , it is not possible

 How to detect negative cycle in Graph?
 after performing all relaxation N-1 time for every edge , if after N-1th time value of any vertice decrease 
 It means graph has negative cycle.

 Bellman ford Algorithm works in Directed Graph , so for undirected you need to make 2 Directed edges for u and v nodes

 Here is implementation in java of bellman ford 
     
 class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = (int)(1e8);
        dist[S] = 0;
        // V x E
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
