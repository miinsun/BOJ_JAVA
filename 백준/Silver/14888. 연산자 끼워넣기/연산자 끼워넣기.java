/* 백준 백트래킹 - 14888 :: 연산자 끼어넣기 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int[] op = new int [4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int sum, int level) {		
		if(level == n) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i == 0) dfs(sum + arr[level], level + 1);
				else if(i == 1) dfs(sum - arr[level], level + 1);
				else if(i == 2) dfs(sum * arr[level], level + 1);
				else dfs(sum / arr[level], level + 1);	
				op[i]++;
			}
		}
	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		
		dfs(arr[0], 1);
		
		System.out.println(max);
		System.out.println(min);

		br.close();
	}
}
