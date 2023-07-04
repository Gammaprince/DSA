/*
This is long code because first we make vis array true for which we can't change X->O after that , We applied BFS. Easy! 
*/


public void solve(char[][] board) {
        int n = board.length , m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            if(board[i][0]=='O') {
                q.add(new int[]{i,0});
                vis[i][0] = true;
            }
            if(board[i][m-1]=='O') {
                q.add(new int[]{i,m-1});
                vis[i][m-1] = true;
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(board[0][i]=='O') {
                q.add(new int[]{0,i});
                vis[0][i] = true;
            }
            if(board[n-1][i]=='O') {
                q.add(new int[]{n-1,i});
                vis[n-1][i] = true;
            }
        }
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        while(!q.isEmpty()){
            int[] pair = q.remove();
            int row = pair[0];
            int col = pair[1];
            for(int i = 0 ; i < 4 ; i++){
                int newRow = row + drow[i];
                int newCol = col + dcol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && board[newRow][newCol]=='O' && vis[newRow][newCol]==false){
                    q.add(new int[]{newRow,newCol});
                    vis[newRow][newCol] = true;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j]=='X'){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] pair = q.remove();
            int row = pair[0];
            int col = pair[1];
            for(int i = 0 ; i < 4 ; i++){
                int newRow = row+drow[i];
                int newCol = col+dcol[i];
                if(newRow>=0 && newRow<n && newCol >= 0 && newCol<m && vis[newRow][newCol] == false){
                    q.add(new int[]{newRow,newCol});
                    vis[newRow][newCol] = true;
                    board[newRow][newCol] = 'X';
                }
            }
        }
    }
