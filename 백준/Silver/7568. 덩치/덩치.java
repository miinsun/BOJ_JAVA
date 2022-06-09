/* 백준 브루트 포스 - 7568 :: 덩치 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int [n][2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 본인보다 덩치가 큰 사람 수 구하기
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int bigMan = 0;
			for(int j = 0; j < n; j++) {
				if(i == j)
					continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) { // 덩치(키, 몸무게)가 더 큰 사람
					bigMan++;
				}	
			}
			sb.append(bigMan + 1).append(' ');
		}
		
		System.out.println(sb);
		sc.close();
	}
}
