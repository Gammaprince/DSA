/*
We used Priority - Queue 
why priority queue?
because with the priority queue you have to process first less distance nodes after that large distance , which gives correct ans
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
