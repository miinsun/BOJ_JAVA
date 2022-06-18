/* 백준 DFS - 12851 :: 괄호 추가하기 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer> digits = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	
	static void dfs(int sum, int depth) {
		if(depth >= ops.size()) {
			max = Integer.max(sum, max);
			return;
		}
		
		// 괄호를 안한 경우
		dfs(calc(sum, digits.get(depth + 1), ops.get(depth)), depth + 1);
		
		// 괄호를 한 경우
		if(depth + 1 < ops.size()) {
			int bracket = calc(digits.get(depth + 1), digits.get(depth + 2), ops.get(depth + 1));
			dfs(calc(sum, bracket, ops.get(depth)), depth + 2);
		}
	}
	
	static int calc(int num1, int num2, int op) {
		switch (op) {
        case '+':
            return num1 + num2;
        case '-':
            return num1 - num2;
        case '*':
            return num1 * num2;
        }
        return -1;
	}
	
	public static void main(String[] args)throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				digits.add(c - '0');
			}
			else {
				ops.add(c);
			}
		}
		
		dfs(digits.get(0), 0);
		
		System.out.println(max);
		br.close();
		
	}
}
