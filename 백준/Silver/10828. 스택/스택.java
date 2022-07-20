/* 백준 스택/큐 - 10828 :: 스택 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s){
				case "push" : 
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop" :{
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.pop());
					break;
				}
				case "size" : 
					System.out.println(stack.size());
					break;
				case "empty" :{
					if(stack.isEmpty()) System.out.println(1);
					else System.out.println(0);
					break;
				}
				case "top" : {
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.peek());
					break;
				}
			}
		}
		
	}
}