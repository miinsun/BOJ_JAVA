/* 백준 완전탐색 - 1062 :: 가르침 */
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int max = 0;
    static String[] list;
    static int n, k;
    
    static void dfs(int alpha, int len) {
    	if(len > k)
    		return; 
        if (len == k) {
            int sum = 0;
            
            for(String s : list) {
            	boolean isIn = true;
            	
            	for(char c : s.toCharArray()){
            		if(visited[c - 'a'] == false) {
            			isIn = false;
            			break;
            		}
            	}

                if (isIn) {
                    sum++;
                }
            }

            max = Math.max(sum, max);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, len + 1);
                visited[i] = false;
            }
        }
    }
    
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		list = new String[n];
		for(int i = 0; i < n; i++) {
			list[i] = sc.next();
			list[i] = list[i].substring(4, list[i].length() - 4);
		}
		
		if (k < 5) {
            System.out.println(0);
        } else if (k == 26) {
            System.out.println(n);
        }else {
    		k -= 5;
    		
    		visited = new boolean[26];
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;
            
            dfs(0, 0);
            System.out.println(max);
        }
		
        sc.close();
	}
}