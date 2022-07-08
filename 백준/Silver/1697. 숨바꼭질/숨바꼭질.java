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
		
		int[] min = new int[100001]; 
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		min[n] = 1;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			// 동생을 만나면 카운트 증가
			if(cur == k)
				cnt++;
			
			// 앞으로 한칸 걸어가기
			if(cur - 1 >= 0 && cur - 1 <= 100000) {
				if(min[cur - 1] == 0 || min[cur - 1] >= min[cur] + 1) {
					min[cur - 1] = min[cur] + 1;
					q.add(cur - 1);
				}
			}
			
			// 뒤로 한칸 걸어가기
			if(cur + 1 >= 0 && cur + 1 <= 100000) {
				if(min[cur + 1] == 0 || min[cur + 1] >= min[cur] + 1) {
					min[cur + 1] = min[cur] + 1;
					q.add(cur + 1);
				}
			}
			
			// 순간이동
			if(cur * 2 >= 0 && cur * 2 <= 100000) {
				if (min[cur * 2] == 0 || min[cur * 2] >= min[cur] + 1) {
					min[cur * 2] = min[cur] + 1;
					q.add(cur * 2);
				}
			}
		}
		
		System.out.println(min[k] - 1);
		br.close();
		
	}
}
