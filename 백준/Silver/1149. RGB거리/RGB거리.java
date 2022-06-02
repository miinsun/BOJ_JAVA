/* 백준 동적 계획법 1 - 1149 :: RGB거리 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 0 ~ n까지 집의 수
		// 0 : 빨강, 1 : 초록, 2 : 파랑
		int[][] paint = new int[n + 1][3];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			paint[i][0] = Integer.parseInt(st.nextToken());
			paint[i][1] = Integer.parseInt(st.nextToken());
			paint[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n; i++) {
			paint[i][0] += Math.min(paint[i-1][1], paint[i-1][2]);
			paint[i][1] +=  Math.min(paint[i-1][0], paint[i-1][2]);
			paint[i][2] +=  Math.min(paint[i-1][0], paint[i-1][1]);
		}
		
		System.out.println(Math.min(Math.min(paint[n - 1][0], paint[n - 1][1]), paint[n - 1][2]));
		br.close();
	} 
}
