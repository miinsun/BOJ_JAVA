/* 백준 - 13549 :: 숨바꼭질 3 */
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
		Arrays.fill(min, -1);
		min[n] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();

			// 앞으로 한칸 걸어가기
			if(cur - 1 >= 0 && cur - 1 <= 100000) {
				if(min[cur - 1] == -1 || min[cur - 1] > min[cur] + 1) {
					min[cur - 1] = min[cur] + 1;
					q.add(cur - 1);
				}
			}
			
			// 뒤로 한칸 걸어가기
			if(cur + 1 >= 0 && cur + 1 <= 100000) {
				if(min[cur + 1] == -1 || min[cur + 1] > min[cur] + 1) {
					min[cur + 1] = min[cur] + 1;
					q.add(cur + 1);
				}
			}
			
			// 순간이동
			if(cur * 2 >= 0 && cur * 2 <= 100000) {
				if (min[cur*2] == -1 || min[cur * 2] > min[cur]) {
					min[cur * 2] = min[cur];
					q.add(cur * 2);
				}
			}
		}
		
		System.out.println(min[k]);
		br.close();
		
	}
}
