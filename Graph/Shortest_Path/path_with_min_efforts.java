/*
This problem can be solved using 2 ways 
1*** BFS + BINARY SEARCH
2** DIJKSTRA'S ALGORITHM

1-> first we found all ways which have binary min efforts <= efforts then if it says yes then we move binary search to right until we
found right false return left
2 using dijkstra's algorithm 

*/
//Binary Search Code
    private int[] d = {0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int lo = 0, hi = 1_000_000;
        while (lo < hi) {
            int effort = lo + (hi - lo) / 2;
            if (isPath(heights, effort)) {
                hi = effort;
            }else {
                lo = effort + 1;
            }
        }
        return lo;
    }
    private boolean isPath(int[][] h, int effort) {
        int m = h.length, n = h[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) {
                return true;
            }
            for (int k = 0; k < 4; ++k) {
                int r = x + d[k], c = y + d[k + 1];
                if (0 <= r && r < m && 0 <= c && c < n && effort >= Math.abs(h[r][c] - h[x][y]) && seen.add(r * n + c)) {
                    q.offer(new int[]{r, c});
                }
            } 
        }
        return false;
    }



//DIJKSTRA'S CODE
public int minimumEffortPath(int[][] heights) {
        int n = heights.length , m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        });
        int[][] vis = new int[n][m];
        for(int[] k : vis) Arrays.fill(k,Integer.MAX_VALUE);
        pq.add(new int[]{0,0,0});
        vis[0][0] = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int x = arr[0] , y = arr[1];
            if(x == n-1 && y == m-1){
                return arr[2];
            }
            int[] drow = {-1 , 0 , 1 , 0};
            int[] dcol = {0 , -1 , 0 , 1};
            int curr = 0;
            for(int i = 0 ; i < 4 ; i++){
                int nrow = x + drow[i];
                int ncol = y + dcol[i];
                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0){
                     curr = Math.max(arr[2],Math.abs(heights[x][y] - heights[nrow][ncol]));
                     if(vis[nrow][ncol] > curr){
                         pq.add(new int[]{nrow,ncol,curr});
                         vis[nrow][ncol] = curr;
                     }
                }  
            }
        }
        return -1;
    }
