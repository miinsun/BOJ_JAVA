import java.util.*;
import java.io.*;

public class Main {
	static int n, result = Integer.MAX_VALUE;
	static int[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = stoi(br.readLine());
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	dp = new int[61][61][61];
    	int[] arr = new int[3];
    	for(int i = 0; i < n; i++) {
    		arr[i] = stoi(stk.nextToken());
    	}
    	
    	DFS(arr,0);
    	System.out.println(result);
    	
    	br.close();
	}
	
	static int[] arrA = {9,9,3,3,1,1};
	static int[] arrB = {3,1,9,1,9,3};
	static int[] arrC = {1,3,1,9,3,9};
	
	static void DFS(int[] arr, int cnt) {
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		// 한번 방문한 상태에서 현재 수 보다 dp로 저장한 수가 더 작은 경우 
		if(dp[a][b][c] <= cnt && dp[a][b][c] != 0) {
			return;
		}
		// 종료 조건
		if(a == 0 && b == 0 && c == 0) {
			result = Math.min(result, cnt);
			return;
		}
		dp[a][b][c] = cnt;
		
		// 뮤탈리스크가 공격 할 수 있는 모든 경우의 수를 따진다.
		int nA, nB, nC;
		for(int i = 0; i < 6; i++) {
			nA = a - arrA[i];
			nB = b - arrB[i];
			nC = c - arrC[i];
			if(nA < 0) nA = 0;
			if(nB < 0) nB = 0;
			if(nC < 0) nC = 0;
			DFS(new int[] {nA, nB, nC}, cnt + 1);
		}
	}
	
	
	static int stoi(String str) {
    	return Integer.parseInt(str);
    }
}