/*
Hash function is good if its generating uniformly distributing index 

1 -> index = large_key % m 
here m should not be 2 power or 10 power to avoid non-uniform distribution , Prime numbers are good because they avoid common factors hence we
get more uniformly distribution 

2 -> for  string = "abcd
Hashing functino should not be of sum like sum of ASCII values of abcd this will result in non-uniformness because all permutation of abcd will fall in same index 
hence this will be collision 
to avoid collision or better distribution we can use str[0]*x^0 + str[1]*x^1 + ... str[n]*x^n;
This will handle all permutations of abcd or any string hence will be more closer to good hashing function

3-> Universal Hashing -> this hashing group of hashing function expects constant time , but in worst case it can also linear time
*/
