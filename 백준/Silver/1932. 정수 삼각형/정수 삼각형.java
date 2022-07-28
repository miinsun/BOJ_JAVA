/* 백준 동적 계획법 1 - 1932 :: 정수 삼각형 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 삼각형의 크기
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = n - 1; i > 0; i--) {
			for(int j = 0; j < i; j++)
				arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
		}
		
		System.out.println(arr[0][0]);
		
		br.close();
	} 
}
