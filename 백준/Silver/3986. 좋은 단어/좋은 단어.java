/* 백준 - 3986 :: 좋은 단어 */
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		int answer = 0;
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			Stack<Character> stack = new Stack<>();
			
			for(char c : s.toCharArray()) {
				if(stack.isEmpty())
					stack.add(c);
				else {
					if(stack.peek() == c) {
						stack.pop();
					}
					else {
						stack.add(c);
					}
				}
			}
			
			if(stack.isEmpty())
				answer++;
		}
		
		System.out.println(answer);
		
        sc.close();
	}
}