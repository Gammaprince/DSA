/*
Approach: first sort the array then find LIS type pattern then 
create hash and dp array to backtrack or print subset which divides each other 


*/

public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] temp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(hash,-1);
        int mx = 0 , idx = -1;
        for(int i = 0 ; i < n ; i++){
            int max = 0 , curr = 0;
            for(int j = i-1 ; j >= 0 ; j--){
                if(nums[i]%nums[j] == 0 && curr<temp[j]){
                    curr = temp[j];
                    hash[i] = j;
                    max = Math.max(max,temp[j]);
                }
            }
            temp[i] = 1+max;
            if(temp[i]>mx){
                idx = i;
                mx = temp[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        while(hash[idx]!=-1){
            list.add(nums[idx]);
            idx = hash[idx];
        }
        list.add(nums[idx]);
        return list;
    }
