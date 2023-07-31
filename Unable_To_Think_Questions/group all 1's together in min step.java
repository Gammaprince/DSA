/*
1 0 0 0 1 1 0 0 
make window size of length of 1's and count number zeros in that 
for more detail see code
*/

class Solution {
    public int minSwaps(int[] nums) {
        int ct = 0 ,  n = nums.length;
        for(int k : nums) ct+=k;
        int j = ct , zero = 0 , one = 0;
        for(int i = 0 ; i < ct ; i++) {
            if(nums[i] == 0) zero++;
            else one++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(zero,min);
            if(nums[i]==0) zero--;
            else one--;
            if(nums[j%n] == 0) zero++;
            else one++;
            j++;
        }
        return min;
    }
}
