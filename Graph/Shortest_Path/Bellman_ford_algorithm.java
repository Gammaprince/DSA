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
