/* 백준 스택/큐 - 10845 :: 큐 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		int back = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch(s){
				case "push" : 
					back = Integer.parseInt(st.nextToken());
					q.add(back);
					break;
				case "pop" :{
					if(q.isEmpty()) System.out.println(-1);
					else System.out.println(q.poll());
					break;
				}
				case "size" : 
					System.out.println(q.size());
					break;
				case "empty" :{
					if(q.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
				}
				case "front" : {
					if(q.isEmpty()) System.out.println(-1);
					else System.out.println(q.peek());
					break;
				}
				case "back" : {
					if(q.isEmpty()) System.out.println(-1);
					else {
						System.out.println(back);
					}
					break;
				}
			}
		}
		
	}
}