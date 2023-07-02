/*
This is Flood Fill Algorithm . It is basic technique to fill all neighbour element with condition 
This Code uses DFS technique to solve Flood Fill Problem

We can also use BFS to solve this problem

As this problem is simple . I am not expalining it in detail.


We Also taking visited array because in the case of same element it will give Stack Over Flow.
*/

public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length , n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];
        int setColor = image[sr][sc];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans[i][j] = image[i][j];
            }
        }
        dfs(ans,vis,color,setColor,sr,sc);
        return ans;
    }
    public void dfs(int[][] arr , boolean[][] vis, int newColor , int initialColor , int r , int c){
        int m = arr.length;
        int n = arr[0].length;
      
      // This is good technique to call all neighbour's recursive calls
      
        int[] drow = {-1 , 0 , +1 , 0};
        int[] dcol = {0 , +1 , 0 , -1};
        arr[r][c] = newColor;
        vis[r][c] = true;
        for(int i = 0 ; i < 4 ; i++){
            r = r + drow[i];
            c = c + dcol[i];
            
            if(newR>=0 && newR<m && newC >= 0 && newC<n && arr[newR][newC]==initialColor && vis[newR][newC] == false) dfs(arr,vis,newColor,initialColor,r,c);
        }
    }
