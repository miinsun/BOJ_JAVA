/* 백준 플로이드워셜 - 11404 :: 플로이드 */
import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[][] distance;
	static final int INF = 9999999;

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		distance = new int[n + 1][n + 1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == j) continue;
				distance[i][j] = INF;
			}
		}
		
		for(int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int time = sc.nextInt();
			distance[start][end] = Math.min(distance[start][end], time);
		}
		
		/* 플로이드 워셜 알고리즘 수행 */
		// 기준이 되는 거쳐가는 노드
		for(int i = 1; i <= n; i++) {
			// 출발하는 노드
			for(int j = 1; j <= n; j++) {
				// 도착하는 노드
				for(int k = 1; k <= n; k++) {
					distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(distance[i][j] == INF) System.out.print("0 ");
				else
					System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
		
        sc.close();
	}
}