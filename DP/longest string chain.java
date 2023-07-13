/*
This question teached me that dp[i] = Math.max(1+dp[j],dp[i]) with Arrays.fill(dp,1) also true and shorter 
first we sorted array length wise then 
perform LIS pattern here for string

we also matched string here , see code for more details
*/

public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        int n = words.length , ans = 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0 ; i < n ; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(words[i].length()-1==words[j].length()){
                    int l = 0 , m = 0;
                    while(l < words[i].length() && m < words[j].length()){
                        if(words[i].charAt(l) != words[j].charAt(m)) l++;
                        else {
                            l++;
                            m++;
                        }
                    }
                    if(l-m <= 1) dp[i] = Math.max(1+dp[j],dp[i]);
                }
            }
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
