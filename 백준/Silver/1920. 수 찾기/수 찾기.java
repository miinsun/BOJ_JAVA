/* 백준 이분탐색 - 1920 :: 수 찾기 */
import java.io.*;
import java.util.*;

public class Main {	
	static int[] arr1;

	public static boolean isIn(int target) {
		int lt = 0;
		int rt = arr1.length - 1;
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(arr1[mid] == target)
				return true;
			
			if(arr1[mid] < target) {
				lt = mid + 1;
			}
			else {
				rt = mid - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr1 = new int[n];
		for(int i = 0; i < n; i++)
			arr1[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr1);
		int m = Integer.parseInt(br.readLine());	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			if(isIn(Integer.parseInt(st.nextToken())))
				sb.append(1).append('\n');
			else
				sb.append(0).append('\n');
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
