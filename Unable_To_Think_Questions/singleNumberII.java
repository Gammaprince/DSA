/*
Problem link : https://leetcode.com/problems/single-number-ii/

Approach : Count all set bits of all numbers upto 32 times (Binary representation). If found 3x+1 set bits then add this bit to the ans

*/

 public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0 ; i < 32 ; i++){
            int setBits = 0;
            for(int j = 0 ; j < nums.length ; j++) {
                if(((nums[j]>>i)&1)==1) setBits++;
            }
            if(setBits%3 == 1) {
                result|=1<<i;
            }
        }
        return result;
    }
