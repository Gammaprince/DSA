/*
We have used prefix sum to calculate sum or substract value in range for eg here range is k , for every range k we have to substract value so that in end whole array become zero 

if we susbtract element from starting and do it one by one until array becomes zero , it is valid bruteforce approach , but it gives TLE 
so to overcome TLE , we have used prefix sum to calculate our ans without getting TLE , because it is O(N) solution trick
*/
public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n+1];
        temp[0] -= nums[0];
        temp[k] += nums[0];
        for(int i = 1 ; i < n ; i++){
          //temp[i] jo effective value h , abhi current prefix mein 
           temp[i]+=temp[i-1];
           if(temp[i]+nums[i]>0 && i+k<=n){
             // temp[i+k] mein temp[i]+nums[i] add kar dia jisse is value ka effect i+k-1 tak hi rahe 
               temp[i+k] = temp[i]+nums[i];
             // temp[i] me temp[i] + nums[i] substract kar dia 
               temp[i] -= temp[i]+nums[i];
           }
        }
        for(int i = 0; i < n; i++){
            if(nums[i]+temp[i]!=0) return false;
        }
        return true;
        
    }
