import java.util.*;

class Solution {
    static int answer;
    static ArrayList<Integer> list;
    
    public boolean isSosu(int n){
        if(n == 1 || n == 0)
            return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public void dfs(String s, String tmp, int len, int depth, boolean[] visited){
        if(depth == len){
            int num = Integer.parseInt(tmp);
            if(!list.contains(num)){
                list.add(num);
            }
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(visited[i] == false){
                visited[i] = true;
                dfs(s, tmp + s.charAt(i), len, depth + 1, visited);
                visited[i] = false;
            }
        }
        
    }
    
    public int solution(String numbers) {
        answer = 0;
        list = new ArrayList<>();
        
        for(int i = 1; i <= numbers.length(); i++){
            boolean[] visited = new boolean[numbers.length()];
            dfs(numbers, "", i, 0, visited);
        }
        
        for(int num : list){
            if(isSosu(num)){
                answer++;
            }
        }
        return answer;
    }
}