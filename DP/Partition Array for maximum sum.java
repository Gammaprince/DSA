/*
This is simple problem : just front partiotion array and find max all of them 
always remember strier's approach for forming recurrence relation that is 
Step 1 -> Express everything in terms of index
Step 2 -> find all possibilities
Step 3 -> find max/min out of all possibilities
Step 4 -> Write base cases
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return ways(arr,0,k,dp);
    }
    public int ways(int[] arr , int i , int k , int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int ways = 0 , maxx = 0;
        for(int j = i ; j < i+k && j < arr.length ; j++){
            maxx = Math.max(arr[j],maxx);
           ways = Math.max(maxx*(j-i+1)+ways(arr,j+1,k,dp),ways);
        }
        return dp[i] = ways;
    }
}
