/*
If we put vis == true before loop , there would be wrong ans because there is someother BFS call can manipulate data of curr cell every time 
so ensure that alway puts vis == true inside for loop 

you can also put vis == true outside for-loop but you need to ensure that first data can't be manipulate by some other BFS call 
so put condition accordingly 
*/

public int[][] updateMatrix(int[][] mat) {
        int n = mat.length , m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j]==0) {
                    q.add(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        while(!q.isEmpty()){
            int[] pair = q.remove();
            int row = pair[0];
            int col = pair[1];
            int step = pair[2];
            dist[row][col] = step;
            for(int i = 0 ; i < 4 ; i++){
                int newRow = row+drow[i];
                int newCol = col+dcol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol] == false){
                    q.add(new int[]{newRow,newCol,step+1});
                    vis[newRow][newCol] = true;
                }
            }
        }
        return dist;
