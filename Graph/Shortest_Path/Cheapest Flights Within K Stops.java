/*
This problem is different as not usual like normal dijastra's , here instead of distance or cost 
we prioritize-steps in priority , node with min steps will consider first

Why prioritize- steps?
just because there may be cause where min distance is not able to achieve results because of involvement of k steps here 
so first prioritize steps 

if node with min step considering first and steps are increasing only by one , we can apply simle BFS here 
so for simple BFS Time complexity : E
and for unusual dijastra's Tc : ElogV
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<int[]>());
        for(int i = 0 ; i < flights.length ; i++){
            List<int[]> l = adj.get(flights[i][0]);
            l.add(new int[]{flights[i][1],flights[i][2]});
        }
        int size = adj.size();
        int[] vis = new int[size];
        Arrays.fill(vis,(int)1e5);
        if(src >= size) return -1;
        pq.add(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int step = arr[0];
            int node = arr[1];
            int cost = arr[2];
            if(node == dst){
                continue;
            }
            if(step > k ) continue;
            for(int[] s : adj.get(node)){
                    if(vis[s[0]] > cost+s[1]){
                          vis[s[0]] = cost+s[1];
                          pq.add(new int[]{step+1,s[0],cost+s[1]});
                    }
            }
        }
        if(vis[dst] == (int)(1e5)) return -1;
        return vis[dst];
    }
}
