/*
We used Priority - Queue 
why priority queue?
because with the priority queue you have to process first less distance nodes after that large distance , which gives correct ans

*** We can also use queue but it would be quite bruteforce approach , since dijastra's algo is greedy in nature it is optimal
*** using set dijastra is little more optimal

TC of Dijastra's Algo = O(E*log(V))
where E = no of Edges in graph
      V = no of Vertex/Nodes in graph


There is a Derivation of this Time Complexity 

outer while loop run in V times *(popingout(heap(heap_size)) + pushing(heap(heap_size))*no_of_edges_of_vertex(iterating adjacenty list))
V*((log(heap_size) + ne * log(heap_size)
V*(log(heap_size)(1+ne))
in most dense graph no of edges must be V-1 , so ne = V-1 
V*(log(heap_size)(V)

V*V(log(heap_size)

in worst case priority_queue can put all node again and again so it would be heap_size = V^2

V*V(log(V*V))
V*V*2(log(V))

since in worst case edges V-1 for every vertex/node it would be V*(V-1) , so V*V = E

hence ,
 E*log(V) 

 proved 


*/
static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        
        int[] vis = new int[V];
        Arrays.fill(vis,(int)1e6);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else return a[1]-b[1];
        });
        pq.add(new int[]{0,S});
        vis[S] = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int node = arr[1];
            int dist = arr[0];
            for(ArrayList<Integer> k : adj.get(node)){
                int newDist = dist + k.get(1);
                int newNode = k.get(0);
                if(vis[newNode]>newDist){
                    vis[newNode] = newDist;
                    pq.add(new int[]{newDist,newNode});
                }
            }
        }
        return vis;
    }
