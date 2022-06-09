/* 백준 백트래킹 - 15649 :: N과 M (1) */
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visit;
	
	public static void dfs(int n, int m, int level) {
		if(level == m) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[level] = i + 1;
				dfs(n, m, level + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		visit = new boolean[n];
		dfs(n, m , 0);
		
		br.close();
	}
}
