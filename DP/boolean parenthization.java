/*
We need to identify that in how many ways '&','|' and '^' true , first we identify number of true false , we can get from left and right , then after we can return number of ways 
for which operator returns True 

for more detail see code ...
*/

class Solution {
    static int countWays(int N, String s) {
        int[][][] dp = new int[N][N][2];
        for(int[][] k : dp){
            for(int[] t : k){
                Arrays.fill(t,-1);
            }
        }
        return ways(s,0,N-1,1,dp);
    }
    public static int ways(String s, int i, int j , int isTrue , int[][][] dp) {
        if (i == j) {
            if(isTrue==1){
                if(s.charAt(i)=='T') return 1;
                else return 0;
            }
            else {
                if(s.charAt(i)=='F') return 1;
                else return 0;
            }
        }
        if (i > j)
            return 0;
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        int ways = 0 , m = 1003;
        for (int k = i + 1; k < j; k += 2) {
            int lt = ways(s,i,k-1,1,dp);
            int rt = ways(s,k+1,j,1,dp);
            int lf = ways(s,i,k-1,0,dp);
            int rf = ways(s,k+1,j,0,dp);
            
            if(s.charAt(k)=='&'){
                if(isTrue==1) ways = (ways + lt*rt)%m;
                else ways = (ways + lt*rf + lf*rt + lf*rf)%m;
            }
            else if(s.charAt(k)=='|'){
                if(isTrue==1) ways = (ways + (lt*rt)%m + (lt*rf)%m + (lf*rt)%m)%m;
                else ways = (ways + (lf*rf)%m)%m;
            }
            else {
                if(isTrue==1) ways = (ways + (lt*rf)%m + (lf*rt)%m)%m;
                else ways = (ways + (lt*rt)%m + (lf*rf)%m)%m;
            }
        }
        return dp[i][j][isTrue] = ways;
    }
