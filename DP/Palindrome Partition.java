/*
This solution is ON^3 because we are checking for extra palindrome so we can also precompute for palindrome part hence this solution would be of ON^2
We used front partition here to find minimum cuts so that every substring remaining would be palindrome 

so here is solution's code for better understanding 

*/

class Solution {


    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return ways(s, 0,dp)-1;
    }

    public int ways(String s, int i,int[] dp) {
        if (i >= s.length())
            return 0;
            
        if(dp[i]!=-1) return dp[i];

        int ways = Integer.MAX_VALUE;
        for (int k = i; k < s.length(); k++) {
            if (isPal(s, i, k)) {
                ways = Math.min(ways, 1 + ways(s, k + 1,dp));
            }
        }

        
        return dp[i] = ways;
    }

    public boolean isPal(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
