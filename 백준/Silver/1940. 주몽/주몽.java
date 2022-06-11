/* 백준 - 1940 :: 주몽 */
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = 0;
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(m == (arr[i] + arr[j]) && !visited[i] && !visited[j]) {
					answer++;
					visited[i] = true;
					visited[j] = true;
				}
			}
		}
		
		System.out.println(answer);
		
        sc.close();
	}
}