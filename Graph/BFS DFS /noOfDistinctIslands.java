/*
The idea here to distince island using relative difference like 
1 1 0 1 1
1 0 0 1 0
we represent first island as list like this -> [00 , 01 , 10] for second like we can firt choose first part of island then find relative difference -> [00,01,10] so this is same as first

(x-i+""+y-j) -> this will make difference island list if islands are same or distince here is code ->
*/

int countDistinctIslands(int[][] arr) {
       int n = arr.length , m = arr[0].length;
       HashSet<ArrayList<String>> set = new HashSet<>();
		boolean[][] vis = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		int[] drow = {-1 , 0 , +1 , 0};
		int[] dcol = {0 , +1 , 0 , -1};
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				if(vis[i][j] == false && arr[i][j] == 1){
				    q.add(new int[]{i,j});
					ArrayList<String> list = new ArrayList<>();
				    while(!q.isEmpty()){
						int[] aa = q.remove();
						int x = aa[0];
						int y = aa[1];
						list.add(""+(x-i)+(y - j));
						for(int k = 0 ; k < 4 ; k++){
							int newRow = x + drow[k];
							int newCol = y + dcol[k];
							if(newRow>=0 && newRow < n && newCol >= 0 && newCol<m && vis[newRow][newCol] == false && arr[newRow][newCol]==1){
							    q.add(new int[]{newRow,newCol});
								vis[newRow][newCol] = true;
						    }
						}
						
				    }
				    set.add(list);
				}
			}
		}
		return set.size();
