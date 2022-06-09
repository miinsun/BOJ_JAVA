/* 백준 DP - 11053 :: 가장 긴 증가하는 부분 수열 */
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
				
		int [] dy = new int[n];
		dy[0] = 1;
		int answer = 1;
		for(int i = 1; i < n; i++) {
			int max = 0;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
			}
			dy[i] = max + 1;
			answer = Math.max(answer , dy[i]);
		}
		
		System.out.println(answer);
	}
}
