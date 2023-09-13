/*
count all at their own position 
make mat to count all ones mat[i][j] = mat[i-1][j] row - wise 
then move accordingly from top and count all matrices 

T.C = O(M*N*N)
*/
class Solution {
    public int numSubmat(int[][] dp) {
        int n = dp.length , m = dp[0].length , ans = 0;
        int[][] mat = new int[n][m];

        for(int j = 0; j < m; j++) mat[0][j] = dp[0][j];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dp[i][j] == 0) continue;
                mat[i][j] = dp[i][j] + mat[i - 1][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < m ; j++){
            if(mat[i][j] == 0) continue;
            int a = (int)(1e7);
            for(int k = j ; k < m ; k++){
              if(mat[i][k] == 0) break;
              a = Math.min(a,mat[i][k]);
              ans+=a;
            }
          }
        }
        return ans;
    }
}
