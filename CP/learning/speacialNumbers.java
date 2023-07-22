/*
If we see pattern like this 1-> 3^0   2-> 3^1   3-> 3^0+3^1   4-> 3^2   5->3^0+3^2    6->3^1+3^2   7->3^3;
We can get nth ans of this series by using binary exponenetiation (This is different binary Exponentiation)
for eg i want to find 5th ans of above series then 
1   0  1 -> 5 (k) in binary
3^2 0  3^0 = 3^0 + 3^2 as you can see above in series 5th number is same like here hence we have to find binary exponentionation to solve this problem
*/

void solve() {
    int n , k , ans = 0 , p = 1;
    cin>>n>>k;
    f(j,0,31){
        if(k & (1<<j)){
            ans = (ans + p)%MOD;
        }
        p*=n;
        p%=MOD;
    }
    cout<<ans<<endl;
}
