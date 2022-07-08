/* 백준 - 12851 :: 숨바꼭질 2 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[100001]; 
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		cnt[n] = 1;
		
		int answer = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == k)
				answer++;
			if(cur - 1 >= 0 && cur - 1 <= 100000) {
				if(cnt[cur - 1] == 0 || cnt[cur - 1] >= cnt[cur] + 1) {
					cnt[cur - 1] = cnt[cur] + 1;
					q.add(cur - 1);
				}
			}
			
			if(cur + 1 >= 0 && cur + 1 <= 100000) {
				if(cnt[cur + 1] == 0 || cnt[cur + 1] >= cnt[cur] + 1) {
					cnt[cur + 1] = cnt[cur] + 1;
					q.add(cur + 1);
				}
			}
			
			if(cur * 2 >= 0 && cur * 2 <= 100000) {
				if (cnt[cur * 2] == 0 || cnt[cur * 2] >= cnt[cur] + 1) {
					cnt[cur * 2] = cnt[cur] + 1;
					q.add(cur * 2);
				}
			}
		}
		
		System.out.println(cnt[k] - 1);
		System.out.println(answer);
		br.close();
		
	}
}
