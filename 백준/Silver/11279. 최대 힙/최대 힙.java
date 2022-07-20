/* 백준 우선순위큐 - 11279 :: 최대 힙 */
import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue <> (Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {	// 가장 큰 수를 출력
				if(q.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(q.poll()).append('\n');
			}
			else {	// 큐에 x를 추가
				q.add(x);
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
