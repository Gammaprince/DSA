/*
This problem is from BFS , wherever question says minimum number of operation then also consider BFS. because BFS runs on level-wise which is good in minimum number of opertions 
questions.

We are also used vis array because we don't want to re-calculate and trap in loop so we are going along with vis array here 

I also used set as vis thing but it was not working because may be it is slower than normal arr I/O operations
*/

public int minimumOperations(int[] nums, int start, int goal) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[1001];
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int[] pair = q.remove();
            int x = pair[0];
            int step = pair[1];
            if(x == goal) return step;
            if(x>1000 || x<0 || vis[x] == true) continue;
            vis[x] = true;
            for(int i = 0 ; i < nums.length ; i++){
                q.add(new int[]{x+nums[i],step+1});
                q.add(new int[]{x-nums[i],step+1});
                q.add(new int[]{x^nums[i],step+1});
            }
        }
        return -1;
    }
