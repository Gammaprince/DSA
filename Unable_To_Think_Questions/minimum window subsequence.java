// this is three pointer approach , I have solved it with little approach which i saw from youtube , first you need to put i = 0 , j = 0 , k = 0;
// then move j matching with k in t string , after complete match make j-- and i = j , and now reverse match such that you can get minimum windows possible 
class Solution {
    
    public static String minWindow(String s, String t) {
        int n = t.length() , m = s.length();
        int i = 0 , j = 0 , k = 0 , x = 0 , y = 0 , ans = Integer.MAX_VALUE;
        String res = "";
        while(j <= m){
            if(k < n && j < m && s.charAt(j) == t.charAt(k)){
                k++;
            }
            else if(k >= n && j <= m) {
                k--;
                j--;
                i = j;
                while(k >= 0){
                    if(s.charAt(i) == t.charAt(k)){
                        k--;
                    }
                    i--;
                }
                i++;
                k++;
                if(j-i+1 < ans){
                    ans = j-i+1;
                    x = j;
                    y = i;
                }
                j = i;
                i++;
            }
            j++;
        }
        if(x == 0 && y == 0) return "";
        return s.substring(y,x+1);
    }
}
