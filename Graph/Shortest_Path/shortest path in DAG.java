/*
We have Djistra's and belman ford algo to find solution but they are not effeceint because we can make use of DAG and topo sort concept
to optimize solution O(M+N)
Q1-Why we need toposort in DAG to find shortest Distance?
Ans- 0->1->3
     |  A  A
     V  |  |
     2--|--|
     so 0[1,5][2,2]
        1[3,1]
        2[1,1][3,7]
        3[]
  so here , if you use simple BFS/DFS you would end up getting incorrect result , why 
  before processing 1 you need to process 2 , to find shortest result of 1 , if you don't do that you will not have shortest distance of
  1 in queue
  so we need toposort to first process all dependencies of 1


*/
