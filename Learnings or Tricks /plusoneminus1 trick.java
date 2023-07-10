/*
This trick is very important , when you have to increase or decrease in range of array and you are taking n^2 time then this trick must be work

Trick : Trick is to add/substract current element in new array and add it to +1 index where you want to add/substract number and this is where it works 
code as follows :-
*/
public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        if(n==1 && trips[0][0]<=capacity) return true;
        else if(n==1 && trips[0][0]>capacity) return false;
        int[] temp = new int[1001];
        for(int i = 0 ; i < n ; i++){
            temp[trips[i][1]] += trips[i][0];
            temp[trips[i][2]] -= trips[i][0];
        }
        int cnt = 0;
        for(int i = 0 ; i <= 1000 ; i++){
            cnt+=temp[i];
            temp[i] = cnt;
        }
        for(int i = 0 ; i <= 1000 ; i++){
            if(capacity<temp[i]) return false;
        }
        return true;
    }
