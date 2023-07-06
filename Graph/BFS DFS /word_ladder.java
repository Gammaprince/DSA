/*
This problem is good , We used BFS to find minimum operation to reach endWord 
Learning : We can use BFS in minimum operation cases 
Learning : String can also be used as char[] arr = str.toCharArray() to replace character in O(1) Time Complexity
*/

class Pair{
    String x;
    int y;
    public Pair(String x , int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < wordList.size() ; i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair pair = q.remove();
            String original = pair.x;
            int step = pair.y;
            if(original.equals(endWord)) return step;
            for(int i = 0 ; i < original.length() ; i++){
                char[] arr = original.toCharArray();
                for(char ch = 'a' ; ch<='z' ; ch++){
                    arr[i] = ch;
                    String temp = new String(arr);
                    if(set.contains(temp)){
                        q.add(new Pair(temp,step+1));
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}
