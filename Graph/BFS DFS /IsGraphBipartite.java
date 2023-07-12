/*
First I was doing mistake to not count level wise by not inserting for loop inside while loop to count each level , second mistake i was doing
is of not considering it for disconnected components

so for every not visited cell , we have running again whole process , to handle disconnected component as well

bipartite means can color node adjacten without having adjacent node as same color.
here is code after so much of debugging 
*/

public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length , m = graph[0].length;
        int[] color = new int[n];
        for(int s = 0 ; s < n ; s++){
            if(color[s]==0){
            int c = 2;
            q.add(s);
            while(!q.isEmpty()){
            int size = q.size();
            if(c==2) c=1;
            else c=2;
            for(int l = 0 ; l < size ; l++){
                int aa = q.remove();
                for(int i = 0 ; i < graph[aa].length ; i++){
                    if(color[graph[aa][i]]==0){
                        q.add(graph[aa][i]);
                        color[graph[aa][i]] = c;
                    }
                    else if(color[graph[aa][i]]==color[aa]) {
                        return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
