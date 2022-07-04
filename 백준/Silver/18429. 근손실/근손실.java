/* 백준 DFS - 18429 :: 근손실 */

import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int[] fitness;
	static boolean[] visited;
	static int answer;
	
	/* 순열 만들기*/
	static void DFS(int sum, int depth) {
		// 종료 조건
		if(depth == n) {
			answer++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			// 중복 검사
			if(!visited[i]) {
				// 근손실이 왔을 때 500이상일 때만 계속해서 진행한다
				if(sum + fitness[i] - k >= 500) {
					visited[i] = true;
					// 바뀐 중량을 반영하고 dfs 깊이를 증가
					DFS(sum + fitness[i] - k, depth + 1);
					visited[i] = false;
				}
			}
		}
		
	}
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		fitness = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			fitness[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[n];
		answer = 0;
		
		// 기본 중량은 500부터 시작
		DFS(500, 0);
		
		System.out.println(answer);
		br.close();
		return ;
	}
}