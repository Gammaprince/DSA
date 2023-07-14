/*
Toposort : Toposort is kind of sorting which defines that if u -> v then u comes first before v in linear ordering 
for e.g   5 -> 0 <- 4
          |         |
          V         V
          2 -> 3 -> 1
In this case linear ordering should be in 5 4 2 3 1 0
Course schedule II is related question to this topological sorting 

so for toposort we use Stack to reverse Order and find our toposort ordering , why ? Stack , because It is LIFO datastructure which is useful here because we finalyy have to reverse DFS 
call to get ans 

Here is code to get better understanding
*/

 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                DFS(adj,i,stack,vis);
            }
        }
        int i = 0;
        int[] ans = new int[stack.size()];
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
    public static void DFS(ArrayList<ArrayList<Integer>> adj , int node , Stack<Integer> st , boolean[] vis){
        vis[node] = true;
        for(int k : adj.get(node)){
            if(!vis[k]){
                DFS(adj,k,st,vis);
            }
        }
        st.push(node);
    }
