/*
It is pick not pick dp , i was unable to solve 

simply add number at your level and check if its max then return 
it is because at base condition if we took wrong decision then it would return -1e8 number 

*/

class Solution {
   
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for(int[] k : dp) Arrays.fill(k,-1);
        return sum(nums,nums.length-1,0,dp);
    }
    public int sum(int[] nums , int i , int rem , int[][] dp){
        if(i<0){
            if(rem == 0) return 0;
            return (int)(-1e8);
        }
        if(dp[i][rem]!=-1) return dp[i][rem];
        return dp[i][rem] = Math.max(nums[i] + sum(nums,i-1,(rem+nums[i])%3,dp) , sum(nums,i-1,rem,dp));
    }
}
